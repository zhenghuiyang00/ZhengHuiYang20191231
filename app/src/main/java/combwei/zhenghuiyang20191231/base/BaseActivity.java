package combwei.zhenghuiyang20191231.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import combwei.zhenghuiyang20191231.base.mvp.BasePresenter;
import combwei.zhenghuiyang20191231.base.mvp.IBaseView;
/*
* @作者:郑惠洋
* @创建日期:2019/12/31 10:06
*/
public abstract class BaseActivity<H, P extends BasePresenter> extends AppCompatActivity implements IBaseView {
    Unbinder unbinder;
    public P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayoutId());

        unbinder= ButterKnife.bind(this);

        presenter=initPresenter();
        if (presenter!=null){
            presenter.attach(this);
        }

        initView();
        initData();

    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract P initPresenter();

    protected abstract int bindLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder!=null){
            unbinder.unbind();
        }
        if (presenter!=null){
            presenter.dettach();
        }
    }
}
