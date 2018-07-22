package pers.lxk.smart4j.framework.bean;

import pers.lxk.smart4j.framework.util.CastUtil;

import java.util.Map;

/**
 * @Description: 请求参数对象
 */
public class Param {

    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    /**根据参数名称获取long型参数
     * @param name
     * @return
     */
    public long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }

    /**获取所有字段信息
     * @return
     */
    public Map<String, Object> getMap() {
        return paramMap;
    }
}
