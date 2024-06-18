package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.AnchoredDraggableState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ModalBottomSheet.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\u001c\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u001a\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\u0096\u0001\u0010\u0011\u001a\u00020\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00120\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020!2\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020\u00120%¢\u0006\u0002\b\u0016H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u001a@\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\r2\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0014\b\u0002\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001c0\u00142\b\b\u0002\u0010.\u001a\u00020\u001cH\u0007\u001aH\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\r2\u0006\u0010/\u001a\u0002002\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0014\b\u0002\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001c0\u00142\b\b\u0002\u0010.\u001a\u00020\u001cH\u0007\u001a3\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020!2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00120%2\u0006\u00104\u001a\u00020\u001cH\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u00106\u001a9\u00107\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\r2\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001c0\u0014H\u0007¢\u0006\u0002\u00109\u001aE\u00107\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\r2\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0014\b\u0002\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001c0\u00142\b\b\u0002\u0010:\u001a\u00020\u001cH\u0007¢\u0006\u0002\u0010;\u001aA\u00107\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\r2\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+2\u0006\u0010:\u001a\u00020\u001c2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001c0\u0014H\u0007¢\u0006\u0002\u0010<\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0004\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006=²\u0006\n\u0010>\u001a\u00020,X\u008a\u0084\u0002"}, d2 = {"MaxModalBottomSheetWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ModalBottomSheetPositionalThreshold", "ModalBottomSheetVelocityThreshold", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "state", "Landroidx/compose/material/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "ModalBottomSheetAnchorChangeCallback", "Landroidx/compose/material/AnchoredDraggableState$AnchorChangedCallback;", "Landroidx/compose/material/ModalBottomSheetValue;", "Landroidx/compose/material/ModalBottomSheetState;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "ModalBottomSheetLayout", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "sheetGesturesEnabled", "", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "scrimColor", "content", "Lkotlin/Function0;", "ModalBottomSheetLayout-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/ModalBottomSheetState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ModalBottomSheetState", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmValueChange", "isSkipHalfExpanded", "density", "Landroidx/compose/ui/unit/Density;", "Scrim", "color", "onDismiss", "visible", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberModalBottomSheetState", "confirmStateChange", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ModalBottomSheetState;", "skipHalfExpanded", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ModalBottomSheetState;", "(Landroidx/compose/material/ModalBottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ModalBottomSheetState;", "material_release", "alpha"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ModalBottomSheetKt {
    private static final float ModalBottomSheetPositionalThreshold = Dp.m5218constructorimpl(56);
    private static final float ModalBottomSheetVelocityThreshold = Dp.m5218constructorimpl(125);
    private static final float MaxModalBottomSheetWidth = Dp.m5218constructorimpl(640);

    public static final /* synthetic */ float access$getModalBottomSheetPositionalThreshold$p() {
        return ModalBottomSheetPositionalThreshold;
    }

    public static final /* synthetic */ float access$getModalBottomSheetVelocityThreshold$p() {
        return ModalBottomSheetVelocityThreshold;
    }

    public static /* synthetic */ ModalBottomSheetState ModalBottomSheetState$default(ModalBottomSheetValue modalBottomSheetValue, Density density, AnimationSpec animationSpec, Function1 function1, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i & 8) != 0) {
            function1 = new Function1<ModalBottomSheetValue, Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(ModalBottomSheetValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            };
        }
        if ((i & 16) != 0) {
            z = false;
        }
        return ModalBottomSheetState(modalBottomSheetValue, density, animationSpec, function1, z);
    }

    public static final ModalBottomSheetState ModalBottomSheetState(ModalBottomSheetValue initialValue, Density density, AnimationSpec<Float> animationSpec, Function1<? super ModalBottomSheetValue, Boolean> confirmValueChange, boolean isSkipHalfExpanded) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
        ModalBottomSheetState it = new ModalBottomSheetState(initialValue, animationSpec, isSkipHalfExpanded, confirmValueChange);
        it.setDensity$material_release(density);
        return it;
    }

    public static /* synthetic */ ModalBottomSheetState ModalBottomSheetState$default(ModalBottomSheetValue modalBottomSheetValue, AnimationSpec animationSpec, Function1 function1, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i & 4) != 0) {
            function1 = new Function1<ModalBottomSheetValue, Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetState$3
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(ModalBottomSheetValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            };
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return ModalBottomSheetState(modalBottomSheetValue, animationSpec, function1, z);
    }

    @Deprecated(message = "This constructor is deprecated. Density must be provided by the component. Please use the constructor that provides a [Density].", replaceWith = @ReplaceWith(expression = "\n            ModalBottomSheetState(\n                initialValue = initialValue,\n                density =,\n                animationSpec = animationSpec,\n                isSkipHalfExpanded = isSkipHalfExpanded,\n                confirmStateChange = confirmValueChange\n            )\n            ", imports = {}))
    public static final ModalBottomSheetState ModalBottomSheetState(ModalBottomSheetValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super ModalBottomSheetValue, Boolean> confirmValueChange, boolean isSkipHalfExpanded) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
        Intrinsics.checkNotNullParameter(confirmValueChange, "confirmValueChange");
        return new ModalBottomSheetState(initialValue, animationSpec, isSkipHalfExpanded, confirmValueChange);
    }

    public static final ModalBottomSheetState rememberModalBottomSheetState(final ModalBottomSheetValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super ModalBottomSheetValue, Boolean> function1, boolean skipHalfExpanded, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        $composer.startReplaceableGroup(-126412120);
        ComposerKt.sourceInformation($composer, "C(rememberModalBottomSheetState)P(2)442@17797L7:ModalBottomSheet.kt#jmzs0o");
        if ((i & 2) != 0) {
            AnimationSpec animationSpec2 = SwipeableDefaults.INSTANCE.getAnimationSpec();
            animationSpec = animationSpec2;
        }
        if ((i & 4) != 0) {
            Function1 confirmValueChange = new Function1<ModalBottomSheetValue, Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$rememberModalBottomSheetState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(ModalBottomSheetValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            };
            function1 = confirmValueChange;
        }
        if ((i & 8) != 0) {
            skipHalfExpanded = false;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-126412120, $changed, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:436)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd($composer);
        final Density density = (Density) consume;
        $composer.startMovableGroup(170051607, initialValue);
        ComposerKt.sourceInformation($composer, "447@18058L646");
        final AnimationSpec<Float> animationSpec3 = animationSpec;
        final Function1<? super ModalBottomSheetValue, Boolean> function12 = function1;
        final boolean z = skipHalfExpanded;
        ModalBottomSheetState modalBottomSheetState = (ModalBottomSheetState) RememberSaveableKt.m2596rememberSaveable(new Object[]{initialValue, animationSpec, Boolean.valueOf(skipHalfExpanded), function1, density}, (Saver) ModalBottomSheetState.INSTANCE.Saver(animationSpec, function1, skipHalfExpanded, density), (String) null, (Function0) new Function0<ModalBottomSheetState>() { // from class: androidx.compose.material.ModalBottomSheetKt$rememberModalBottomSheetState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ModalBottomSheetState invoke() {
                return ModalBottomSheetKt.ModalBottomSheetState(ModalBottomSheetValue.this, density, animationSpec3, function12, z);
            }
        }, $composer, 72, 4);
        $composer.endMovableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return modalBottomSheetState;
    }

    @Deprecated(message = "This function is deprecated. confirmStateChange has been renamed to confirmValueChange.", replaceWith = @ReplaceWith(expression = "rememberModalBottomSheetState(initialValue, animationSpec, confirmStateChange, false)", imports = {}))
    public static final ModalBottomSheetState rememberModalBottomSheetState(ModalBottomSheetValue initialValue, AnimationSpec<Float> animationSpec, boolean skipHalfExpanded, Function1<? super ModalBottomSheetValue, Boolean> confirmStateChange, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
        $composer.startReplaceableGroup(-409288536);
        ComposerKt.sourceInformation($composer, "C(rememberModalBottomSheetState)P(2!1,3)495@20118L185:ModalBottomSheet.kt#jmzs0o");
        if ((i & 2) != 0) {
            AnimationSpec animationSpec2 = SwipeableDefaults.INSTANCE.getAnimationSpec();
            animationSpec = animationSpec2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-409288536, $changed, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:490)");
        }
        ModalBottomSheetState rememberModalBottomSheetState = rememberModalBottomSheetState(initialValue, animationSpec, confirmStateChange, skipHalfExpanded, $composer, ($changed & 14) | 64 | (($changed >> 3) & 896) | (($changed << 3) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberModalBottomSheetState;
    }

    @Deprecated(message = "This function is deprecated. confirmStateChange has been renamed to confirmValueChange.", replaceWith = @ReplaceWith(expression = "rememberModalBottomSheetState(initialValue, animationSpec, confirmValueChange = confirmStateChange)", imports = {}))
    public static final ModalBottomSheetState rememberModalBottomSheetState(ModalBottomSheetValue initialValue, AnimationSpec<Float> animationSpec, Function1<? super ModalBottomSheetValue, Boolean> confirmStateChange, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(confirmStateChange, "confirmStateChange");
        $composer.startReplaceableGroup(-1928569212);
        ComposerKt.sourceInformation($composer, "C(rememberModalBottomSheetState)P(2)523@21187L174:ModalBottomSheet.kt#jmzs0o");
        if ((i & 2) != 0) {
            AnimationSpec animationSpec2 = SwipeableDefaults.INSTANCE.getAnimationSpec();
            animationSpec = animationSpec2;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1928569212, $changed, -1, "androidx.compose.material.rememberModalBottomSheetState (ModalBottomSheet.kt:519)");
        }
        ModalBottomSheetState rememberModalBottomSheetState = rememberModalBottomSheetState(initialValue, animationSpec, confirmStateChange, false, $composer, ($changed & 14) | 3136 | ($changed & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberModalBottomSheetState;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02c7  */
    /* renamed from: ModalBottomSheetLayout-Gs3lGvM */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1128ModalBottomSheetLayoutGs3lGvM(final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.ui.Modifier r36, androidx.compose.material.ModalBottomSheetState r37, boolean r38, androidx.compose.ui.graphics.Shape r39, float r40, long r41, long r43, long r45, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, androidx.compose.runtime.Composer r48, final int r49, final int r50) {
        /*
            Method dump skipped, instructions count: 967
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ModalBottomSheetKt.m1128ModalBottomSheetLayoutGs3lGvM(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.ModalBottomSheetState, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: Scrim-3J-VO9M */
    public static final void m1129Scrim3JVO9M(final long color, final Function0<Unit> function0, final boolean visible, Composer $composer, final int $changed) {
        Modifier.Companion dismissModifier;
        Object value$iv$iv;
        Object value$iv$iv2;
        Composer $composer2 = $composer.startRestartGroup(-526532668);
        ComposerKt.sourceInformation($composer2, "C(Scrim)P(0:c#ui.graphics.Color)700@29148L121,704@29295L29,720@29810L62,716@29701L171:ModalBottomSheet.kt#jmzs0o");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(color) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(visible) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-526532668, $dirty2, -1, "androidx.compose.material.Scrim (ModalBottomSheet.kt:694)");
            }
            if (color != Color.INSTANCE.m2985getUnspecified0d7_KjU()) {
                final State alpha$delegate = AnimateAsStateKt.animateFloatAsState(visible ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, $composer2, 48, 28);
                final String closeSheet = Strings_androidKt.m1196getString4foXLRw(Strings.INSTANCE.m1190getCloseSheetUdPEhr4(), $composer2, 6);
                $composer2.startReplaceableGroup(1010559499);
                ComposerKt.sourceInformation($composer2, "707@29432L37,708@29522L121");
                if (visible) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    int i = ($dirty2 >> 3) & 14;
                    $composer2.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                    boolean invalid$iv$iv = $composer2.changed(function0);
                    Object it$iv$iv = $composer2.rememberedValue();
                    if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = new ModalBottomSheetKt$Scrim$dismissModifier$1$1(function0, null);
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv$iv);
                    int i2 = $dirty2 & 112;
                    $composer2.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
                    boolean invalid$iv$iv2 = $composer2.changed(closeSheet) | $composer2.changed(function0);
                    Object it$iv$iv2 = $composer2.rememberedValue();
                    if (!invalid$iv$iv2 && it$iv$iv2 != Composer.INSTANCE.getEmpty()) {
                        value$iv$iv2 = it$iv$iv2;
                        $composer2.endReplaceableGroup();
                        dismissModifier = SemanticsModifierKt.semantics(pointerInput, true, (Function1) value$iv$iv2);
                    }
                    value$iv$iv2 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$dismissModifier$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semantics) {
                            Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                            SemanticsPropertiesKt.setContentDescription(semantics, closeSheet);
                            final Function0<Unit> function02 = function0;
                            SemanticsPropertiesKt.onClick$default(semantics, null, new Function0<Boolean>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$dismissModifier$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    function02.invoke();
                                    return true;
                                }
                            }, 1, null);
                        }
                    };
                    $composer2.updateRememberedValue(value$iv$iv2);
                    $composer2.endReplaceableGroup();
                    dismissModifier = SemanticsModifierKt.semantics(pointerInput, true, (Function1) value$iv$iv2);
                } else {
                    dismissModifier = Modifier.INSTANCE;
                }
                $composer2.endReplaceableGroup();
                Modifier then = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(dismissModifier);
                Object key1$iv = Color.m2939boximpl(color);
                int i3 = $dirty2 & 14;
                $composer2.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv3 = $composer2.changed(key1$iv) | $composer2.changed(alpha$delegate);
                Object value$iv$iv3 = $composer2.rememberedValue();
                if (!invalid$iv$iv3) {
                    Object key1$iv2 = Composer.INSTANCE.getEmpty();
                    if (value$iv$iv3 != key1$iv2) {
                        $composer2.endReplaceableGroup();
                        CanvasKt.Canvas(then, (Function1) value$iv$iv3, $composer2, 0);
                    }
                }
                value$iv$iv3 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                        invoke2(drawScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(DrawScope Canvas) {
                        float Scrim_3J_VO9M$lambda$2;
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        long j = color;
                        Scrim_3J_VO9M$lambda$2 = ModalBottomSheetKt.Scrim_3J_VO9M$lambda$2(alpha$delegate);
                        DrawScope.m3487drawRectnJ9OG0$default(Canvas, j, 0L, 0L, Scrim_3J_VO9M$lambda$2, null, null, 0, 118, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv3);
                $composer2.endReplaceableGroup();
                CanvasKt.Canvas(then, (Function1) value$iv$iv3, $composer2, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ModalBottomSheetKt$Scrim$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i4) {
                ModalBottomSheetKt.m1129Scrim3JVO9M(color, function0, visible, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    public static final float Scrim_3J_VO9M$lambda$2(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> anchoredDraggableState, Orientation orientation) {
        return new ModalBottomSheetKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(anchoredDraggableState, orientation);
    }

    public static final AnchoredDraggableState.AnchorChangedCallback<ModalBottomSheetValue> ModalBottomSheetAnchorChangeCallback(final ModalBottomSheetState state, final CoroutineScope scope) {
        return new AnchoredDraggableState.AnchorChangedCallback<ModalBottomSheetValue>() { // from class: androidx.compose.material.ModalBottomSheetKt$ModalBottomSheetAnchorChangeCallback$1

            /* compiled from: ModalBottomSheet.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ModalBottomSheetValue.values().length];
                    try {
                        iArr[ModalBottomSheetValue.Hidden.ordinal()] = 1;
                    } catch (NoSuchFieldError e) {
                    }
                    try {
                        iArr[ModalBottomSheetValue.HalfExpanded.ordinal()] = 2;
                    } catch (NoSuchFieldError e2) {
                    }
                    try {
                        iArr[ModalBottomSheetValue.Expanded.ordinal()] = 3;
                    } catch (NoSuchFieldError e3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // androidx.compose.material.AnchoredDraggableState.AnchorChangedCallback
            public final void onAnchorsChanged(ModalBottomSheetValue prevTarget, Map<ModalBottomSheetValue, Float> prevAnchors, Map<ModalBottomSheetValue, Float> newAnchors) {
                ModalBottomSheetValue modalBottomSheetValue;
                Intrinsics.checkNotNullParameter(prevTarget, "prevTarget");
                Intrinsics.checkNotNullParameter(prevAnchors, "prevAnchors");
                Intrinsics.checkNotNullParameter(newAnchors, "newAnchors");
                Float previousTargetOffset = prevAnchors.get(prevTarget);
                switch (WhenMappings.$EnumSwitchMapping$0[prevTarget.ordinal()]) {
                    case 1:
                        modalBottomSheetValue = ModalBottomSheetValue.Hidden;
                        break;
                    case 2:
                    case 3:
                        boolean hasHalfExpandedState = newAnchors.containsKey(ModalBottomSheetValue.HalfExpanded);
                        if (!hasHalfExpandedState) {
                            if (!newAnchors.containsKey(ModalBottomSheetValue.Expanded)) {
                                modalBottomSheetValue = ModalBottomSheetValue.Hidden;
                                break;
                            } else {
                                modalBottomSheetValue = ModalBottomSheetValue.Expanded;
                                break;
                            }
                        } else {
                            modalBottomSheetValue = ModalBottomSheetValue.HalfExpanded;
                            break;
                        }
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                ModalBottomSheetValue newTarget = modalBottomSheetValue;
                float newTargetOffset = ((Number) MapsKt.getValue(newAnchors, newTarget)).floatValue();
                if (!Intrinsics.areEqual(newTargetOffset, previousTargetOffset)) {
                    if (ModalBottomSheetState.this.isAnimationRunning$material_release()) {
                        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new ModalBottomSheetKt$ModalBottomSheetAnchorChangeCallback$1$onAnchorsChanged$1(ModalBottomSheetState.this, newTarget, null), 3, null);
                        return;
                    }
                    boolean didSnapSynchronously = ModalBottomSheetState.this.trySnapTo$material_release(newTarget);
                    if (!didSnapSynchronously) {
                        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new ModalBottomSheetKt$ModalBottomSheetAnchorChangeCallback$1$onAnchorsChanged$2(ModalBottomSheetState.this, newTarget, null), 3, null);
                    }
                }
            }
        };
    }
}
