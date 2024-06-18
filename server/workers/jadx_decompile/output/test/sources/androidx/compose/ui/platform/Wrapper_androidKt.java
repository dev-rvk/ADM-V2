package androidx.compose.ui.platform;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.ui.R;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.UiApplier;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Wrapper.android.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0001\u001a0\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\b\u0010H\u0002¢\u0006\u0002\u0010\u0011\u001a\b\u0010\u0012\u001a\u00020\u000fH\u0002\u001a\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a,\u0010\u0015\u001a\u00020\u0005*\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\b\u0010H\u0000¢\u0006\u0002\u0010\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"DefaultLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "TAG", "", "createSubcomposition", "Landroidx/compose/runtime/Composition;", "container", "Landroidx/compose/ui/node/LayoutNode;", "parent", "Landroidx/compose/runtime/CompositionContext;", "doSetContent", "owner", "Landroidx/compose/ui/platform/AndroidComposeView;", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/platform/AndroidComposeView;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/Composition;", "enableDebugInspectorInfo", "inspectionWanted", "", "setContent", "Landroidx/compose/ui/platform/AbstractComposeView;", "(Landroidx/compose/ui/platform/AbstractComposeView;Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/Composition;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class Wrapper_androidKt {
    private static final String TAG = "Wrapper";
    private static final ViewGroup.LayoutParams DefaultLayoutParams = new ViewGroup.LayoutParams(-2, -2);

    public static final Composition createSubcomposition(LayoutNode container, CompositionContext parent) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(parent, "parent");
        return CompositionKt.Composition(new UiApplier(container), parent);
    }

    public static final Composition setContent(AbstractComposeView $this$setContent, CompositionContext parent, Function2<? super Composer, ? super Integer, Unit> content) {
        Intrinsics.checkNotNullParameter($this$setContent, "<this>");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(content, "content");
        GlobalSnapshotManager.INSTANCE.ensureStarted();
        AndroidComposeView it = null;
        if ($this$setContent.getChildCount() > 0) {
            View childAt = $this$setContent.getChildAt(0);
            if (childAt instanceof AndroidComposeView) {
                it = (AndroidComposeView) childAt;
            }
        } else {
            $this$setContent.removeAllViews();
        }
        if (it == null) {
            Context context = $this$setContent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            it = new AndroidComposeView(context, parent.getEffectCoroutineContext());
            $this$setContent.addView(it.getView(), DefaultLayoutParams);
        }
        AndroidComposeView composeView = it;
        return doSetContent(composeView, parent, content);
    }

    private static final Composition doSetContent(AndroidComposeView owner, CompositionContext parent, Function2<? super Composer, ? super Integer, Unit> function2) {
        if (inspectionWanted(owner)) {
            owner.setTag(R.id.inspection_slot_table_set, Collections.newSetFromMap(new WeakHashMap()));
            enableDebugInspectorInfo();
        }
        Composition original = CompositionKt.Composition(new UiApplier(owner.getRoot()), parent);
        Object tag = owner.getView().getTag(R.id.wrapped_composition_tag);
        WrappedComposition it = tag instanceof WrappedComposition ? (WrappedComposition) tag : null;
        if (it == null) {
            it = new WrappedComposition(owner, original);
            owner.getView().setTag(R.id.wrapped_composition_tag, it);
        }
        it.setContent(function2);
        return it;
    }

    private static final void enableDebugInspectorInfo() {
        if (!InspectableValueKt.isDebugInspectorInfoEnabled()) {
            try {
                Class packageClass = Class.forName("androidx.compose.ui.platform.InspectableValueKt");
                Field field = packageClass.getDeclaredField("isDebugInspectorInfoEnabled");
                field.setAccessible(true);
                field.setBoolean(null, true);
            } catch (Exception e) {
                Log.w(TAG, "Could not access isDebugInspectorInfoEnabled. Please set explicitly.");
            }
        }
    }

    private static final boolean inspectionWanted(AndroidComposeView owner) {
        return Build.VERSION.SDK_INT >= 29 && (WrapperVerificationHelperMethods.INSTANCE.attributeSourceResourceMap(owner).isEmpty() ^ true);
    }
}
