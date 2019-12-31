package combwei.zhenghuiyang20191231.presenter;

import combwei.zhenghuiyang20191231.base.mvp.BasePresenter;
import combwei.zhenghuiyang20191231.contract.HomeContract;
import combwei.zhenghuiyang20191231.model.HomeModel;
/*
* @作者:郑惠洋
* @创建日期:2019/12/31 10:13
*/
public class HomePresenter extends BasePresenter<HomeModel, HomeContract.IView> implements HomeContract.IPresenter {

    @Override
    protected HomeModel initmodel() {
        return new HomeModel();
    }

    @Override
    public void getData(String url) {

    }
}
