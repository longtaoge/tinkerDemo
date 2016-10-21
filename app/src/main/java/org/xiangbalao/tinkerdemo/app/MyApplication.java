package org.xiangbalao.tinkerdemo.app;

import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Created by longtaoge on 16/10/21.
 *
 *    tinker 推荐 本类通过注解自动生成
 */

public class MyApplication extends TinkerApplication {
    protected MyApplication() {
        super( ShareConstants.TINKER_ENABLE_ALL, ApplicationLike.class.getName());
    }
}
