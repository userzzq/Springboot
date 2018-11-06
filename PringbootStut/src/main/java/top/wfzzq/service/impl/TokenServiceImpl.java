package top.wfzzq.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.wfzzq.dao.TbTokenDAO;
import top.wfzzq.entity.JsonMessage;
import top.wfzzq.entity.TbToKenInfo;
import top.wfzzq.service.TokenService;
import top.wfzzq.utils.MyUtils;

/**
 * TbToken的服务 Transactional表示开启事务处理，表示类中的方法调用dao处理数据会在事务中，
 * 要么全部成功，要么全部失败，所以一定要service层处理业务 rollbackFor表示要回滚事务的类型，
 * Exception.class表示方法抛出Exception或者它的子类会事务回滚
 * 
 * @author wanghui
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TokenServiceImpl implements TokenService {
	@Autowired
	private TbTokenDAO tbTokenDAO;

	/**
	 * 创建uuid
	 * @return
	 * @throws Exception
	 */
	private JsonMessage makeNewTonkenInfo() throws Exception {
		// 通过uuId生成随机的token
		String t = UUID.randomUUID().toString();
		TbToKenInfo stoken = new TbToKenInfo();
		stoken.setToken(t);
		// 保存到数据库
		tbTokenDAO.addToken(stoken);
		JsonMessage message = JsonMessage.getSuccess("");
		message.getDatas().put("token", stoken.getToken());
		return message;
	}
    @Override
	public JsonMessage createToKenInfo(TbToKenInfo tokenInfo) throws Exception {
		// 1:查询token是否存在// 2:不存在要创建
		if (tokenInfo == null || tokenInfo.getToken() == null) {
			// 通过uuid生成随机的token
//			tokenInfo=makeNewTonkenInfo();
//			JsonMessage message=JsonMessage.getSuccess("");
//			message.getDatas().put("token",tokenInfo);
//			return message;
			return makeNewTonkenInfo();
		}
		
		TbToKenInfo stoken = tbTokenDAO.queryKenInfo(tokenInfo);
		if (stoken == null) {
			// 通过uuid生成随机的token
//			String t = UUID.randomUUID().toString();
//			stoken = new TbToKenInfo();
//			stoken.setToken(t);
//			// 保存到数据库
//			tbTokenDAO.addToken(stoken);
//			return stoken;
			return makeNewTonkenInfo();
		}
		// 3:存在就更新
		tbTokenDAO.updateToken(stoken);
		// 4:返回token
		JsonMessage message = JsonMessage.getSuccess("");
		message.getDatas().put("token", stoken.getToken());
		return message;
	}
    /**
     * -创建新Token
     * @return
     * @throws Exception
     */
	private TbToKenInfo newToken() throws Exception{
		TbToKenInfo token=new TbToKenInfo();
		token.setToken(UUID.randomUUID().toString());
		tbTokenDAO.addToken(token);
		return token;
	}
	@Override
	public TbToKenInfo checkTbToKenInfo(TbToKenInfo token)throws Exception{
		//客户端没有传入token就需要创建新的token
		if(token==null|| MyUtils.isEmpty(token.getToken())) {
			return newToken();
		}
		//查看tokeninfo是否存在
		TbToKenInfo stoken=tbTokenDAO.queryKenInfo(token);
		if (stoken==null) {
			//不存在就重新创健
			return newToken();
		}
		//存在就更新
		 tbTokenDAO.updateToken(stoken);
		 return stoken;
	}
}
