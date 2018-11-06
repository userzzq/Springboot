package top.wfzzq.springbootmybatisbase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.wfzzq.springbootmybatisbase.dao.TbTokenInfoDAO;
import top.wfzzq.springbootmybatisbase.entity.TbTokenInfo;
import top.wfzzq.springbootmybatisbase.model.UtilModel;
import top.wfzzq.springbootmybatisbase.service.UtilService;
import top.wfzzq.springbootmybatisbase.utils.ImageCode;
import top.wfzzq.springbootmybatisbase.utils.MyUtils;

/**
 * 
 * @author wanghui
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UtilServiceImpl implements UtilService {
	@Autowired
	private TbTokenInfoDAO tbTokenInfoDAO;

	@Override
	public String makeImageCode(UtilModel model) throws Exception {
		// 产品图片校验码
		String code = ImageCode.makeCode();
		// 获取token信息
		TbTokenInfo tokenInfo = model.makeTbTokenInfo();
		// 判断图片检验码是否存在
		TbTokenInfo sinfo = tbTokenInfoDAO.queryImageCode(tokenInfo);
		if (sinfo == null) {
			// 不存在就将图片code写入
			tokenInfo.setInfo(code);
			tbTokenInfoDAO.addImageCode(tokenInfo);
		} else {
			// 存在就更新图片code
			sinfo.setInfo(code);
			tbTokenInfoDAO.updateImageCode(sinfo);
		}
		return code;
	}
	@Override
	public boolean checkImageCode(TbTokenInfo tbTokenInfo) throws Exception{
		//code不存在就返回错误
		if (MyUtils.isEmpty(tbTokenInfo.getInfo())) {
			return false;
			
		}
		//获取数据库中code
		TbTokenInfo sinfo=tbTokenInfoDAO.queryImageCode(tbTokenInfo);
		if (sinfo==null) {
			//不存在就返回false
			return false;
		}
		//删除数据库中的code(只能使用一次)
		tbTokenInfoDAO.deleteImageCode(sinfo);
		//返回数据库中code和传入的code比对结果
		return sinfo.getInfo().equalsIgnoreCase(tbTokenInfo.getInfo());
	}
}
