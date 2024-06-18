package androidx.compose.material.pullrefresh;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PullRefresh.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public /* synthetic */ class PullRefreshKt$pullRefresh$2$2 extends AdaptedFunctionReference implements Function2<Float, Continuation<? super Float>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public PullRefreshKt$pullRefresh$2$2(Object obj) {
        super(2, obj, PullRefreshState.class, "onRelease", "onRelease$material_release(F)F", 4);
    }

    public final Object invoke(float p0, Continuation<? super Float> continuation) {
        Object pullRefresh$lambda$1$onRelease;
        pullRefresh$lambda$1$onRelease = PullRefreshKt.pullRefresh$lambda$1$onRelease((PullRefreshState) this.receiver, p0, continuation);
        return pullRefresh$lambda$1$onRelease;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Float f, Continuation<? super Float> continuation) {
        return invoke(f.floatValue(), continuation);
    }
}
