package top.wfzzq.exception;

/**
 * AppException 应用程序自定义异常（需要指定code和message）
 * @author wanghui
 *
 */
public class AppException extends Exception {
	private int code = 500;
	private static final long serialVersionUID = 4195142914577231919L;

	public AppException(int code, String message) {
		super(message);
		this.code = code;
	}

	public static AppException getAppException(int code, String message) {
		return new AppException(code, message);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}
