package androidx.compose.material.pullrefresh;

import androidx.compose.animation.core.EasingKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: PullRefreshIndicatorTransform.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"pullRefreshIndicatorTransform", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/material/pullrefresh/PullRefreshState;", "scale", "", "material_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PullRefreshIndicatorTransformKt {
    public static /* synthetic */ Modifier pullRefreshIndicatorTransform$default(Modifier modifier, PullRefreshState pullRefreshState, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return pullRefreshIndicatorTransform(modifier, pullRefreshState, z);
    }

    public static final Modifier pullRefreshIndicatorTransform(Modifier $this$pullRefreshIndicatorTransform, final PullRefreshState state, final boolean scale) {
        Intrinsics.checkNotNullParameter($this$pullRefreshIndicatorTransform, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Function1 inspectorInfo$iv = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("pullRefreshIndicatorTransform");
                $this$null.getProperties().set("state", PullRefreshState.this);
                $this$null.getProperties().set("scale", Boolean.valueOf(scale));
            }
        } : InspectableValueKt.getNoInspectorInfo();
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier $this$pullRefreshIndicatorTransform_u24lambda_u241 = GraphicsLayerModifierKt.graphicsLayer(DrawModifierKt.drawWithContent(Modifier.INSTANCE, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope drawWithContent) {
                Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
                ContentDrawScope $this$clipRect_u2drOu3jXo_u24default$iv = drawWithContent;
                int clipOp$iv = ClipOp.INSTANCE.m2938getIntersectrtfAjoo();
                DrawContext $this$withTransform_u24lambda_u246$iv$iv = $this$clipRect_u2drOu3jXo_u24default$iv.getDrawContext();
                long previousSize$iv$iv = $this$withTransform_u24lambda_u246$iv$iv.mo3417getSizeNHjbRc();
                $this$withTransform_u24lambda_u246$iv$iv.getCanvas().save();
                DrawTransform $this$clipRect_rOu3jXo_u24lambda_u244$iv = $this$withTransform_u24lambda_u246$iv$iv.getTransform();
                $this$clipRect_rOu3jXo_u24lambda_u244$iv.mo3420clipRectN_I0leg(-3.4028235E38f, 0.0f, Float.MAX_VALUE, Float.MAX_VALUE, clipOp$iv);
                drawWithContent.drawContent();
                $this$withTransform_u24lambda_u246$iv$iv.getCanvas().restore();
                $this$withTransform_u24lambda_u246$iv$iv.mo3418setSizeuvyYCjk(previousSize$iv$iv);
            }
        }), new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                invoke2(graphicsLayerScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GraphicsLayerScope graphicsLayer) {
                Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                graphicsLayer.setTranslationY(PullRefreshState.this.getPosition$material_release() - Size.m2776getHeightimpl(graphicsLayer.getSize()));
                if (scale && !PullRefreshState.this.getRefreshing$material_release()) {
                    float scaleFraction = RangesKt.coerceIn(EasingKt.getLinearOutSlowInEasing().transform(PullRefreshState.this.getPosition$material_release() / PullRefreshState.this.getThreshold$material_release()), 0.0f, 1.0f);
                    graphicsLayer.setScaleX(scaleFraction);
                    graphicsLayer.setScaleY(scaleFraction);
                }
            }
        });
        return InspectableValueKt.inspectableWrapper($this$pullRefreshIndicatorTransform, inspectorInfo$iv, $this$pullRefreshIndicatorTransform_u24lambda_u241);
    }
}
