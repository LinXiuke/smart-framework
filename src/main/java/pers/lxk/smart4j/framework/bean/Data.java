package pers.lxk.smart4j.framework.bean;

/**
 * @Description: 返回获取数据
 */
public class Data {

    /**
     * 模型数据
     */
    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}
