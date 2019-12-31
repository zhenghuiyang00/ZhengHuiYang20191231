package combwei.zhenghuiyang20191231.model;


import com.google.gson.Gson;

import combwei.zhenghuiyang20191231.contract.HomeContract;
import combwei.zhenghuiyang20191231.model.entity.HomeEntity;
import combwei.zhenghuiyang20191231.utils.OkhttpUtils;
/*
* @作者:郑惠洋
* @创建日期:2019/12/31 10:09
*/
public class HomeModel implements HomeContract.IModel {

    @Override
    public void getData(String url, IModelCallback iModelCallback) {
        OkhttpUtils.getInstance().doGet(url, new OkhttpUtils.OkhttpUtilCallback() {
            @Override
            public void success(String result) {
                HomeEntity homeEntity = new Gson().fromJson(url, HomeEntity.class);
                iModelCallback.success(homeEntity);
            }

            @Override
            public void fialure(Throwable throwable) {
                iModelCallback.failure(throwable);
            }
        });
    }
}
