package top.wfzzq.springbootmybatisbase.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import top.wfzzq.springbootmybatisbase.entity.TbTokenInfo;
import top.wfzzq.springbootmybatisbase.model.TestModel;
import top.wfzzq.springbootmybatisbase.service.TestService;
import top.wfzzq.springbootmybatisbase.service.UtilService;
import top.wfzzq.springbootmybatisbase.utils.JsonMessage;

/**
 * -其它测试控制器
 * 
 * @author wanghui
 *
 */
@RestController
@RequestMapping("/test")
public class TestOtherController {
	/**
	 * -文件上传路径
	 */
	public static final String UPLOAD_DIR = "/uploadfiles/";
	/**
	 * -文件上传保存完整路径
	 */
	private File savePath;
	@Autowired
	private TestService testService;
	@Autowired
	private UtilService utilservice;

	public TestOtherController() {
		// System.getProperty是获取程序执行所在路径
		savePath = new File(System.getProperty("user.dir") + UPLOAD_DIR);
		// 的确目录存在
		if (!savePath.exists()) {
			savePath.mkdirs();
		}
	}

	/**
	 * -测试事务
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/tran")
	public JsonMessage tran(TestModel model) throws Exception {
		// /test/tran{"ctoke.token":"","tokenInfo.infoKey":"","tokenInfo.info":""}

		model.getTokenInfo().setToken(model.getCtoken().getToken());
		return testService.tranAdd(model);
	}

	@RequestMapping("/imageCode")
	public JsonMessage imageCode(TestModel model) throws Exception {
		// /test/imageCode{"imageCode":""}
		// /util/validate.jpg
		// 获取图片校验码
		TbTokenInfo info = model.makeTbTokenInfo();
		info.setInfo(model.getImageCode());
		// 校验
		boolean check = utilservice.checkImageCode(info);
		if (check) {
			return JsonMessage.getSuccess("图片校验码正确");
		} else {
			return JsonMessage.getFail("图片校验失败");
		}
	}

	@RequestMapping("/upload")
	public JsonMessage upload(TestModel model, MultipartFile file) throws Exception {
		// 文件上传需要多一个MultipartFile参数来获取表单中的文件上传信息
		if (file == null || file.isEmpty()) {
			return JsonMessage.getFail("请选择文件上传");
		}
		// 获取文件上传信息
		TestUploadInfo info = new TestUploadInfo();
		// 上传的文件名称
		info.setFilename(file.getOriginalFilename());
		// 上传的文件mime
		info.setMime(file.getContentType());
		// 上传文件大小
		info.setFilesize(file.getSize());
		// 获取上传文件的扩展名
		String ext = "";
		String strExt=".";
		if (info.getFilename().indexOf(strExt) > -1) {
			int index = info.getFilename().lastIndexOf(strExt);
			ext = info.getFilename().substring(index);
		}
		// 生成uuid为保存的文件地址
		File savefile = new File(savePath, UUID.randomUUID().toString() + ext);
		// 生成文件的服务器url地址
		info.setUrl(UPLOAD_DIR + savefile.getName());
		// 保存文件
		InputStream is = file.getInputStream();
		OutputStream os = new FileOutputStream(savefile);
		byte[] bytes = new byte[8 * 1024];
		int len = is.read(bytes);
		while (len > 0) {
			os.write(bytes, 0, len);
			os.flush();
			len = is.read(bytes);
		}
		os.close();
		is.close();
		// 应答
		JsonMessage message = JsonMessage.getSuccess("上传成功");
		message.getDatas().put("uploadinfo", info);
		return message;
	}
}
