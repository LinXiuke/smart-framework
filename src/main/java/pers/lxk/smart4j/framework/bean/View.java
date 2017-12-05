package pers.lxk.smart4j.framework.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 返回视图对象
 * @Author: linxiuke
 * @Date: Create in 2017/12/5
 */
public class View {

    /**
     * 视图路径
     */
    private String path;

    /**
     * 模型数据
     */
    private Map<String, Object> model;

    public View(String path) {
        this.path = path;
        model = new HashMap<>();
    }

    public View addModel(String key, Object value) {
        model.put(key, value);
        return this;
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}