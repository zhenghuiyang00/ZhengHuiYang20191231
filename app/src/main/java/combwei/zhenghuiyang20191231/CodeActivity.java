package combwei.zhenghuiyang20191231;

import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import combwei.zhenghuiyang20191231.base.BaseActivity;
import combwei.zhenghuiyang20191231.base.mvp.BasePresenter;

public class CodeActivity extends BaseActivity {


    @BindView(R.id.qq)
    Button qq;
    @BindView(R.id.wx)
    Button wx;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int bindLayoutId() {
        return R.layout.activity_code;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
