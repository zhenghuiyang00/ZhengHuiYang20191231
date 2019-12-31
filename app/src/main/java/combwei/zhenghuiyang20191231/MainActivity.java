package combwei.zhenghuiyang20191231;

import android.widget.Button;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import combwei.zhenghuiyang20191231.api.Api;
import combwei.zhenghuiyang20191231.base.BaseActivity;
import combwei.zhenghuiyang20191231.contract.HomeContract;
import combwei.zhenghuiyang20191231.model.HomeModel;
import combwei.zhenghuiyang20191231.model.adapter.HomeAdapter;
import combwei.zhenghuiyang20191231.model.entity.HomeEntity;
import combwei.zhenghuiyang20191231.presenter.HomePresenter;
import combwei.zhenghuiyang20191231.R;

/*
 * @作者:郑惠洋
 * @创建日期:2019/12/31 10:07
 */
public class MainActivity extends BaseActivity<HomeModel, HomePresenter> implements HomeContract.IView {


    @BindView(R.id.btn_send)
    Button btnSend;
    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected void initData() {
        presenter.getData(Api.HOME_URL+"api/news/ranking.json");
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        rv.setLayoutManager(new GridLayoutManager(this,2));
    }

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }


    @Override
    protected int bindLayoutId() {
        return R.layout.activity_main;
    }



    @Override
    public void success(HomeEntity homeEntity) {
        HomeAdapter homeAdapter=new HomeAdapter(this,homeEntity.ranking);
        rv.setAdapter(homeAdapter);
    }

    @Override
    public void failure(Throwable throwable) {

    }
}
