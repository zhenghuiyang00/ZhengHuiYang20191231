package combwei.zhenghuiyang20191231.contract;

import combwei.zhenghuiyang20191231.base.mvp.IBaseModel;
import combwei.zhenghuiyang20191231.base.mvp.IBaseView;
import combwei.zhenghuiyang20191231.model.entity.HomeEntity;
/*
* @作者:郑惠洋
* @创建日期:2019/12/31 10:06
*/
public interface HomeContract {

    interface IModel extends IBaseModel{
        void getData(String url,IModelCallback iModelCallback);
        interface IModelCallback{
            void success(HomeEntity homeEntity);
            void failure(Throwable throwable);
        }
    }
    interface  IView extends IBaseView{
        void success(HomeEntity homeEntity);
        void failure(Throwable throwable);
    }

    interface IPresenter{
        void getData(String url);
    }

}
