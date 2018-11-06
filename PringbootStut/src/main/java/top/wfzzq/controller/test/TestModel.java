package top.wfzzq.controller.test;
/**
 * TestModel-测试用的model层，model层可以组合不同的数据传输，以适配页面不同的数据类型
 * @author wanghui
 *
 */

import top.wfzzq.model.BasePageModel;

public class TestModel extends BasePageModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3399355934058583911L;
	private TestEntity entity = new TestEntity();

	public TestModel() {

	}

	public TestEntity getEntity() {
		return entity;
	}

	public void setEntity(TestEntity entity) {
		this.entity = entity;
	}

}
