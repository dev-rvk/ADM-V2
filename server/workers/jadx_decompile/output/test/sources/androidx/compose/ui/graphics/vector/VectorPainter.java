package androidx.compose.ui.graphics.vector;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VectorPainter.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002Jd\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u000f2;\u0010,\u001a7\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020'0-¢\u0006\u0002\b/H\u0001¢\u0006\u0004\b0\u00101J\u0010\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u000fH\u0014J\u0012\u00104\u001a\u00020\u00042\b\u00105\u001a\u0004\u0018\u00010\u0011H\u0014JR\u00106\u001a\u00020\r2\u0006\u00107\u001a\u0002082;\u00109\u001a7\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(*\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b.\u0012\b\b(\u0012\u0004\b\b(+\u0012\u0004\u0012\u00020'0-¢\u0006\u0002\b/H\u0002¢\u0006\u0002\u0010:J\f\u0010;\u001a\u00020'*\u00020<H\u0014R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00118@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR+\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\tR4\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00198@@@X\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b#\u0010\u000b\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\"R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006="}, d2 = {"Landroidx/compose/ui/graphics/vector/VectorPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "()V", "<set-?>", "", "autoMirror", "getAutoMirror$ui_release", "()Z", "setAutoMirror$ui_release", "(Z)V", "autoMirror$delegate", "Landroidx/compose/runtime/MutableState;", "composition", "Landroidx/compose/runtime/Composition;", "currentAlpha", "", "currentColorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "value", "intrinsicColorFilter", "getIntrinsicColorFilter$ui_release", "()Landroidx/compose/ui/graphics/ColorFilter;", "setIntrinsicColorFilter$ui_release", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "isDirty", "setDirty", "isDirty$delegate", "size", "getSize-NH-jbRc$ui_release", "setSize-uvyYCjk$ui_release", "(J)V", "size$delegate", "vector", "Landroidx/compose/ui/graphics/vector/VectorComponent;", "RenderVector", "", HintConstants.AUTOFILL_HINT_NAME, "", "viewportWidth", "viewportHeight", "content", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "Landroidx/compose/runtime/Composable;", "RenderVector$ui_release", "(Ljava/lang/String;FFLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "applyAlpha", "alpha", "applyColorFilter", "colorFilter", "composeVector", "parent", "Landroidx/compose/runtime/CompositionContext;", "composable", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function4;)Landroidx/compose/runtime/Composition;", "onDraw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class VectorPainter extends Painter {
    public static final int $stable = 8;

    /* renamed from: autoMirror$delegate, reason: from kotlin metadata */
    private final MutableState autoMirror;
    private Composition composition;
    private float currentAlpha;
    private ColorFilter currentColorFilter;

    /* renamed from: isDirty$delegate, reason: from kotlin metadata */
    private final MutableState isDirty;

    /* renamed from: size$delegate, reason: from kotlin metadata */
    private final MutableState size;
    private final VectorComponent vector;

    public VectorPainter() {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m2767boximpl(Size.INSTANCE.m2788getZeroNHjbRc()), null, 2, null);
        this.size = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.autoMirror = mutableStateOf$default2;
        VectorComponent $this$vector_u24lambda_u240 = new VectorComponent();
        $this$vector_u24lambda_u240.setInvalidateCallback$ui_release(new Function0<Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainter$vector$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                VectorPainter.this.setDirty(true);
            }
        });
        this.vector = $this$vector_u24lambda_u240;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
        this.isDirty = mutableStateOf$default3;
        this.currentAlpha = 1.0f;
    }

    /* renamed from: getSize-NH-jbRc$ui_release, reason: not valid java name */
    public final long m3587getSizeNHjbRc$ui_release() {
        State $this$getValue$iv = this.size;
        return ((Size) $this$getValue$iv.getValue()).getPackedValue();
    }

    /* renamed from: setSize-uvyYCjk$ui_release, reason: not valid java name */
    public final void m3588setSizeuvyYCjk$ui_release(long j) {
        MutableState $this$setValue$iv = this.size;
        $this$setValue$iv.setValue(Size.m2767boximpl(j));
    }

    public final boolean getAutoMirror$ui_release() {
        State $this$getValue$iv = this.autoMirror;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    public final void setAutoMirror$ui_release(boolean z) {
        MutableState $this$setValue$iv = this.autoMirror;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    public final ColorFilter getIntrinsicColorFilter$ui_release() {
        return this.vector.getIntrinsicColorFilter$ui_release();
    }

    public final void setIntrinsicColorFilter$ui_release(ColorFilter value) {
        this.vector.setIntrinsicColorFilter$ui_release(value);
    }

    private final Composition composeVector(CompositionContext parent, final Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> composable) {
        Composition next;
        Composition existing = this.composition;
        if (existing == null || existing.getDisposed()) {
            next = CompositionKt.Composition(new VectorApplier(this.vector.getRoot()), parent);
        } else {
            next = existing;
        }
        this.composition = next;
        next.setContent(ComposableLambdaKt.composableLambdaInstance(-1916507005, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainter$composeVector$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer $composer, int $changed) {
                VectorComponent vectorComponent;
                VectorComponent vectorComponent2;
                ComposerKt.sourceInformation($composer, "C213@8239L55:VectorPainter.kt#huu6hf");
                if (($changed & 11) != 2 || !$composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1916507005, $changed, -1, "androidx.compose.ui.graphics.vector.VectorPainter.composeVector.<anonymous> (VectorPainter.kt:212)");
                    }
                    Function4<Float, Float, Composer, Integer, Unit> function4 = composable;
                    vectorComponent = this.vector;
                    Float valueOf = Float.valueOf(vectorComponent.getViewportWidth());
                    vectorComponent2 = this.vector;
                    function4.invoke(valueOf, Float.valueOf(vectorComponent2.getViewportHeight()), $composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer.skipToGroupEnd();
            }
        }));
        return next;
    }

    private final boolean isDirty() {
        State $this$getValue$iv = this.isDirty;
        return ((Boolean) $this$getValue$iv.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDirty(boolean z) {
        MutableState $this$setValue$iv = this.isDirty;
        $this$setValue$iv.setValue(Boolean.valueOf(z));
    }

    public final void RenderVector$ui_release(final String name, final float viewportWidth, final float viewportHeight, final Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(1264894527);
        ComposerKt.sourceInformation($composer2, "C(RenderVector)P(1,3,2)233@8813L28,237@8882L117:VectorPainter.kt#huu6hf");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1264894527, $changed, -1, "androidx.compose.ui.graphics.vector.VectorPainter.RenderVector (VectorPainter.kt:221)");
        }
        VectorComponent $this$RenderVector_u24lambda_u241 = this.vector;
        $this$RenderVector_u24lambda_u241.setName(name);
        $this$RenderVector_u24lambda_u241.setViewportWidth(viewportWidth);
        $this$RenderVector_u24lambda_u241.setViewportHeight(viewportHeight);
        final Composition composition = composeVector(ComposablesKt.rememberCompositionContext($composer2, 0), content);
        EffectsKt.DisposableEffect(composition, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.graphics.vector.VectorPainter$RenderVector$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                final Composition composition2 = Composition.this;
                return new DisposableEffectResult() { // from class: androidx.compose.ui.graphics.vector.VectorPainter$RenderVector$2$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        Composition.this.dispose();
                    }
                };
            }
        }, $composer2, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainter$RenderVector$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                VectorPainter.this.RenderVector$ui_release(name, viewportWidth, viewportHeight, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* renamed from: getIntrinsicSize-NH-jbRc */
    public long getIntrinsicSize() {
        return m3587getSizeNHjbRc$ui_release();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.graphics.painter.Painter
    public void onDraw(DrawScope $this$onDraw) {
        Intrinsics.checkNotNullParameter($this$onDraw, "<this>");
        VectorComponent $this$onDraw_u24lambda_u243 = this.vector;
        ColorFilter filter = this.currentColorFilter;
        if (filter == null) {
            filter = $this$onDraw_u24lambda_u243.getIntrinsicColorFilter$ui_release();
        }
        if (!getAutoMirror$ui_release() || $this$onDraw.getLayoutDirection() != LayoutDirection.Rtl) {
            $this$onDraw_u24lambda_u243.draw($this$onDraw, this.currentAlpha, filter);
        } else {
            long pivot$iv$iv = $this$onDraw.mo3491getCenterF1C5BW0();
            DrawContext $this$withTransform_u24lambda_u246$iv$iv$iv = $this$onDraw.getDrawContext();
            long previousSize$iv$iv$iv = $this$withTransform_u24lambda_u246$iv$iv$iv.mo3417getSizeNHjbRc();
            $this$withTransform_u24lambda_u246$iv$iv$iv.getCanvas().save();
            DrawTransform $this$scale_Fgt4K4Q_u24lambda_u242$iv$iv = $this$withTransform_u24lambda_u246$iv$iv$iv.getTransform();
            $this$scale_Fgt4K4Q_u24lambda_u242$iv$iv.mo3424scale0AR0LA0(-1.0f, 1.0f, pivot$iv$iv);
            float scaleX$iv$iv = this.currentAlpha;
            $this$onDraw_u24lambda_u243.draw($this$onDraw, scaleX$iv$iv, filter);
            $this$withTransform_u24lambda_u246$iv$iv$iv.getCanvas().restore();
            $this$withTransform_u24lambda_u246$iv$iv$iv.mo3418setSizeuvyYCjk(previousSize$iv$iv$iv);
        }
        if (isDirty()) {
            setDirty(false);
        }
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyAlpha(float alpha) {
        this.currentAlpha = alpha;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean applyColorFilter(ColorFilter colorFilter) {
        this.currentColorFilter = colorFilter;
        return true;
    }
}
