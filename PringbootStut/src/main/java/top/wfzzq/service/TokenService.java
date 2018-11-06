package top.wfzzq.service;

import top.wfzzq.entity.JsonMessage;
import top.wfzzq.entity.TbToKenInfo;

/**
 * Token的服务
 * @author wanghui
 *
 */
public interface TokenService {
     /**
      * 更新或者返回新token客户端token信息
      * 
      * @param tokenInfo
      * @return
      * @throws Exception
      */
	JsonMessage createToKenInfo(TbToKenInfo tokenInfo) throws Exception;
     /**
      * -检查token信息，不存在就创建新的，否则就更新时间
      * @param toKen 客户端token信息
      * @return
      * @throws Exception
      */
	TbToKenInfo checkTbToKenInfo(TbToKenInfo token) throws Exception;

}
