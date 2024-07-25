package androidx.compose.material3;

import android.view.View;
import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableKt$draggable$1;
import androidx.compose.foundation.gestures.DraggableKt$draggable$2;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ModalBottomSheet.android.kt */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\u001a\u009e\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a¨\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0015H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001aq\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020\u000726\u0010 \u001a2\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110%¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00010!2!\u0010'\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00010\u0013H\u0003\u001a6\u0010(\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0011H\u0001¢\u0006\u0002\u0010)\u001a3\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\u000b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010,\u001a\u00020-H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010/\u001a-\u00100\u001a\u00020\u00072\b\b\u0002\u00101\u001a\u00020-2\u0014\b\u0002\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020-0\u0013H\u0007¢\u0006\u0002\u00103\u001aX\u00104\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u00106\u001a\u00020%2,\u00107\u001a(\u0012\u0004\u0012\u000208\u0012\u0013\u0012\u00110%¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00010!¢\u0006\u0002\b\u0015H\u0003\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00069"}, d2 = {"ModalBottomSheet", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "sheetState", "Landroidx/compose/material3/SheetState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "Landroidx/compose/ui/unit/Dp;", "scrimColor", "dragHandle", "Landroidx/compose/runtime/Composable;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "ModalBottomSheet-xOkiWaM", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;Landroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "ModalBottomSheet-EP0qOeE", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SheetState;Landroidx/compose/ui/graphics/Shape;JJFJLkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ModalBottomSheetAnchorChangeHandler", "Landroidx/compose/material3/AnchorChangeHandler;", "Landroidx/compose/material3/SheetValue;", "state", "animateTo", "Lkotlin/Function2;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "target", "", "velocity", "snapTo", "ModalBottomSheetPopup", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Scrim", "color", "visible", "", "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberModalBottomSheetState", "skipPartiallyExpanded", "confirmValueChange", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "modalBottomSheetSwipeable", "anchorChangeHandler", "screenHeight", "onDragStopped", "Lkotlinx/coroutines/CoroutineScope;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ModalBottomSheet_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:114:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0414  */
    /* renamed from: ModalBottomSheet-EP0qOeE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1600ModalBottomSheetEP0qOeE(final kotlin.jvm.functions.Function0<kotlin.Unit> r38, androidx.compose.ui.Modifier r39, androidx.compose.material3.SheetState r40, androidx.compose.ui.graphics.Shape r41, long r42, long r44, float r46, long r47, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, androidx.compose.foundation.layout.WindowInsets r50, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, androidx.compose.runtime.Composer r52, final int r53, final int r54, final int r55) {
        /*
            Method dump skipped, instructions count: 1127
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ModalBottomSheet_androidKt.m1600ModalBottomSheetEP0qOeE(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.material3.SheetState, androidx.compose.ui.graphics.Shape, long, long, float, long, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01df  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Use ModalBottomSheet overload with windowInset parameter.")
    /* renamed from: ModalBottomSheet-xOkiWaM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m1601ModalBottomSheetxOkiWaM(final kotlin.jvm.functions.Function0 r33, androidx.compose.ui.Modifier r34, androidx.compose.material3.SheetState r35, androidx.compose.ui.graphics.Shape r36, long r37, long r39, float r41, long r42, kotlin.jvm.functions.Function2 r44, final kotlin.jvm.functions.Function3 r45, androidx.compose.runtime.Composer r46, final int r47, final int r48) {
        /*
            Method dump skipped, instructions count: 767
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ModalBottomSheet_androidKt.m1601ModalBottomSheetxOkiWaM(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.material3.SheetState, androidx.compose.ui.graphics.Shape, long, long, float, long, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final SheetState rememberModalBottomSheetState(boolean skipPartiallyExpanded, Function1<? super SheetValue, Boolean> function1, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(-1261794383);
        ComposerKt.sourceInformation($composer, "C(rememberModalBottomSheetState)P(1)318@14402L69:ModalBottomSheet.android.kt#uh7d8r");
        if ((i & 1) != 0) {
            skipPartiallyExpanded = false;
        }
        if ((i & 2) != 0) {
            Function1 confirmValueChange = new Function1<SheetValue, Boolean>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$rememberModalBottomSheetState$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(SheetValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            };
            function1 = confirmValueChange;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1261794383, $changed, -1, "androidx.compose.material3.rememberModalBottomSheetState (ModalBottomSheet.android.kt:315)");
        }
        SheetState rememberSheetState = SheetDefaultsKt.rememberSheetState(skipPartiallyExpanded, function1, SheetValue.Hidden, false, $composer, ($changed & 14) | 384 | ($changed & 112), 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return rememberSheetState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m1602Scrim3JVO9M(final long color, final Function0<Unit> function0, final boolean visible, Composer $composer, final int $changed) {
        Modifier.Companion dismissSheet;
        Object value$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(1053897700);
        ComposerKt.sourceInformation($composer2, "C(Scrim)P(0:c#ui.graphics.Color)327@14631L121,346@15192L62,342@15086L168:ModalBottomSheet.android.kt#uh7d8r");
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
                ComposerKt.traceEventStart(1053897700, $dirty2, -1, "androidx.compose.material3.Scrim (ModalBottomSheet.android.kt:321)");
            }
            if (color != Color.INSTANCE.m2985getUnspecified0d7_KjU()) {
                final State alpha$delegate = AnimateAsStateKt.animateFloatAsState(visible ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, $composer2, 48, 28);
                $composer2.startReplaceableGroup(-1858721447);
                ComposerKt.sourceInformation($composer2, "333@14864L124");
                if (visible) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    int i = ($dirty2 >> 3) & 14;
                    $composer2.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                    boolean invalid$iv$iv = $composer2.changed(function0);
                    Object it$iv$iv = $composer2.rememberedValue();
                    if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = new ModalBottomSheet_androidKt$Scrim$dismissSheet$1$1(function0, null);
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    dismissSheet = SemanticsModifierKt.clearAndSetSemantics(SuspendingPointerInputFilterKt.pointerInput(companion, function0, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv$iv), new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$Scrim$dismissSheet$2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver clearAndSetSemantics) {
                            Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
                        }
                    });
                } else {
                    dismissSheet = Modifier.INSTANCE;
                }
                $composer2.endReplaceableGroup();
                Modifier then = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(dismissSheet);
                Object key1$iv = Color.m2939boximpl(color);
                int i2 = $dirty2 & 14;
                $composer2.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv2 = $composer2.changed(key1$iv) | $composer2.changed(alpha$delegate);
                Object value$iv$iv2 = $composer2.rememberedValue();
                if (!invalid$iv$iv2) {
                    Object key1$iv2 = Composer.INSTANCE.getEmpty();
                    if (value$iv$iv2 != key1$iv2) {
                        $composer2.endReplaceableGroup();
                        CanvasKt.Canvas(then, (Function1) value$iv$iv2, $composer2, 0);
                    }
                }
                value$iv$iv2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$Scrim$1$1
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
                        Scrim_3J_VO9M$lambda$2 = ModalBottomSheet_androidKt.Scrim_3J_VO9M$lambda$2(alpha$delegate);
                        DrawScope.m3487drawRectnJ9OG0$default(Canvas, j, 0L, 0L, Scrim_3J_VO9M$lambda$2, null, null, 0, 118, null);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv2);
                $composer2.endReplaceableGroup();
                CanvasKt.Canvas(then, (Function1) value$iv$iv2, $composer2, 0);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$Scrim$2
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

            public final void invoke(Composer composer, int i3) {
                ModalBottomSheet_androidKt.m1602Scrim3JVO9M(color, function0, visible, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Scrim_3J_VO9M$lambda$2(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier modalBottomSheetSwipeable(Modifier $this$modalBottomSheetSwipeable, final SheetState sheetState, AnchorChangeHandler<SheetValue> anchorChangeHandler, final float screenHeight, Function2<? super CoroutineScope, ? super Float, Unit> function2) {
        Modifier draggable;
        draggable = DraggableKt.draggable($this$modalBottomSheetSwipeable, sheetState.getSwipeableState$material3_release().getSwipeDraggableState(), Orientation.Vertical, (r20 & 4) != 0 ? true : sheetState.isVisible(), (r20 & 8) != 0 ? null : null, (r20 & 16) != 0 ? false : sheetState.getSwipeableState$material3_release().isAnimationRunning(), (r20 & 32) != 0 ? new DraggableKt$draggable$1(null) : null, (r20 & 64) != 0 ? new DraggableKt$draggable$2(null) : new ModalBottomSheet_androidKt$modalBottomSheetSwipeable$1(function2), (r20 & 128) != 0 ? false : false);
        return SwipeableV2Kt.swipeAnchors(draggable, sheetState.getSwipeableState$material3_release(), SetsKt.setOf((Object[]) new SheetValue[]{SheetValue.Hidden, SheetValue.PartiallyExpanded, SheetValue.Expanded}), anchorChangeHandler, new Function2<SheetValue, IntSize, Float>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$modalBottomSheetSwipeable$2

            /* compiled from: ModalBottomSheet.android.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[SheetValue.values().length];
                    try {
                        iArr[SheetValue.Hidden.ordinal()] = 1;
                    } catch (NoSuchFieldError e) {
                    }
                    try {
                        iArr[SheetValue.PartiallyExpanded.ordinal()] = 2;
                    } catch (NoSuchFieldError e2) {
                    }
                    try {
                        iArr[SheetValue.Expanded.ordinal()] = 3;
                    } catch (NoSuchFieldError e3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Float invoke(SheetValue sheetValue, IntSize intSize) {
                return m1606invokeO0kMr_c(sheetValue, intSize.getPackedValue());
            }

            /* renamed from: invoke-O0kMr_c, reason: not valid java name */
            public final Float m1606invokeO0kMr_c(SheetValue value, long sheetSize) {
                Intrinsics.checkNotNullParameter(value, "value");
                switch (WhenMappings.$EnumSwitchMapping$0[value.ordinal()]) {
                    case 1:
                        return Float.valueOf(screenHeight);
                    case 2:
                        if (IntSize.m5377getHeightimpl(sheetSize) >= screenHeight / 2 && !sheetState.getSkipPartiallyExpanded()) {
                            return Float.valueOf(screenHeight / 2.0f);
                        }
                        return null;
                    case 3:
                        if (IntSize.m5377getHeightimpl(sheetSize) != 0) {
                            return Float.valueOf(Math.max(0.0f, screenHeight - IntSize.m5377getHeightimpl(sheetSize)));
                        }
                        return null;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object modalBottomSheetSwipeable$suspendConversion0(Function2 $this$modalBottomSheetSwipeable_u24suspendConversion0, CoroutineScope p0, float p1, Continuation $completion) {
        $this$modalBottomSheetSwipeable_u24suspendConversion0.invoke(p0, Boxing.boxFloat(p1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnchorChangeHandler<SheetValue> ModalBottomSheetAnchorChangeHandler(final SheetState state, final Function2<? super SheetValue, ? super Float, Unit> function2, final Function1<? super SheetValue, Unit> function1) {
        return new AnchorChangeHandler<SheetValue>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetAnchorChangeHandler$1

            /* compiled from: ModalBottomSheet.android.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[SheetValue.values().length];
                    try {
                        iArr[SheetValue.Hidden.ordinal()] = 1;
                    } catch (NoSuchFieldError e) {
                    }
                    try {
                        iArr[SheetValue.PartiallyExpanded.ordinal()] = 2;
                    } catch (NoSuchFieldError e2) {
                    }
                    try {
                        iArr[SheetValue.Expanded.ordinal()] = 3;
                    } catch (NoSuchFieldError e3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // androidx.compose.material3.AnchorChangeHandler
            public final void onAnchorsChanged(SheetValue previousTarget, Map<SheetValue, Float> previousAnchors, Map<SheetValue, Float> newAnchors) {
                SheetValue sheetValue;
                Intrinsics.checkNotNullParameter(previousTarget, "previousTarget");
                Intrinsics.checkNotNullParameter(previousAnchors, "previousAnchors");
                Intrinsics.checkNotNullParameter(newAnchors, "newAnchors");
                Float previousTargetOffset = previousAnchors.get(previousTarget);
                switch (WhenMappings.$EnumSwitchMapping$0[previousTarget.ordinal()]) {
                    case 1:
                        sheetValue = SheetValue.Hidden;
                        break;
                    case 2:
                    case 3:
                        boolean hasPartiallyExpandedState = newAnchors.containsKey(SheetValue.PartiallyExpanded);
                        if (!hasPartiallyExpandedState) {
                            if (!newAnchors.containsKey(SheetValue.Expanded)) {
                                sheetValue = SheetValue.Hidden;
                                break;
                            } else {
                                sheetValue = SheetValue.Expanded;
                                break;
                            }
                        } else {
                            sheetValue = SheetValue.PartiallyExpanded;
                            break;
                        }
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                SheetValue newTarget = sheetValue;
                float newTargetOffset = ((Number) MapsKt.getValue(newAnchors, newTarget)).floatValue();
                if (!Intrinsics.areEqual(newTargetOffset, previousTargetOffset)) {
                    if (SheetState.this.getSwipeableState$material3_release().isAnimationRunning() || previousAnchors.isEmpty()) {
                        function2.invoke(newTarget, Float.valueOf(SheetState.this.getSwipeableState$material3_release().getLastVelocity()));
                    } else {
                        function1.invoke(newTarget);
                    }
                }
            }
        };
    }

    public static final void ModalBottomSheetPopup(final Function0<Unit> onDismissRequest, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed) {
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-627217336);
        ComposerKt.sourceInformation($composer2, "C(ModalBottomSheetPopup)P(1,2)420@17875L7,421@17896L38,422@17963L28,423@18018L29,424@18081L621,446@18708L217:ModalBottomSheet.android.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(onDismissRequest) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(windowInsets) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-627217336, $dirty2, -1, "androidx.compose.material3.ModalBottomSheetPopup (ModalBottomSheet.android.kt:415)");
            }
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localView);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            View view = (View) consume;
            UUID id = (UUID) RememberSaveableKt.m2596rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<UUID>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$id$1
                @Override // kotlin.jvm.functions.Function0
                public final UUID invoke() {
                    return UUID.randomUUID();
                }
            }, $composer2, 3080, 6);
            CompositionContext parentComposition = ComposablesKt.rememberCompositionContext($composer2, 0);
            final State currentContent$delegate = SnapshotStateKt.rememberUpdatedState(content, $composer2, ($dirty2 >> 6) & 14);
            $composer2.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                Intrinsics.checkNotNullExpressionValue(id, "id");
                ModalBottomSheetWindow $this$ModalBottomSheetPopup_u24lambda_u247_u24lambda_u246 = new ModalBottomSheetWindow(onDismissRequest, view, id);
                $this$ModalBottomSheetPopup_u24lambda_u247_u24lambda_u246.setCustomContent(parentComposition, ComposableLambdaKt.composableLambdaInstance(861223805, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$modalBottomSheetWindow$1$1$1
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

                    public final void invoke(Composer $composer3, int $changed2) {
                        Function2 ModalBottomSheetPopup$lambda$5;
                        ComposerKt.sourceInformation($composer3, "C433@18369L285:ModalBottomSheet.android.kt#uh7d8r");
                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(861223805, $changed2, -1, "androidx.compose.material3.ModalBottomSheetPopup.<anonymous>.<anonymous>.<anonymous> (ModalBottomSheet.android.kt:432)");
                            }
                            Modifier modifier$iv = WindowInsetsPadding_androidKt.imePadding(WindowInsetsPaddingKt.windowInsetsPadding(SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$modalBottomSheetWindow$1$1$1.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    invoke2(semanticsPropertyReceiver);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                    SemanticsPropertiesKt.popup(semantics);
                                }
                            }, 1, null), WindowInsets.this));
                            State<Function2<Composer, Integer, Unit>> state = currentContent$delegate;
                            $composer3.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation($composer3, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                            Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                            MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer3, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                            int $changed$iv$iv = (0 << 3) & 112;
                            $composer3.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume2 = $composer3.consume(localDensity);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            Density density$iv$iv = (Density) consume2;
                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume3 = $composer3.consume(localLayoutDirection);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume3;
                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                            Object consume4 = $composer3.consume(localViewConfiguration);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume4;
                            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                            if (!($composer3.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            $composer3.startReusableNode();
                            if ($composer3.getInserting()) {
                                $composer3.createNode(factory$iv$iv$iv);
                            } else {
                                $composer3.useNode();
                            }
                            $composer3.disableReusing();
                            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2583constructorimpl($composer3);
                            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                            $composer3.enableReusing();
                            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                            $composer3.startReplaceableGroup(2058660585);
                            int i = ($changed$iv$iv$iv >> 9) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer3, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            int i2 = ((0 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer3, 321876634, "C439@18616L16:ModalBottomSheet.android.kt#uh7d8r");
                            ModalBottomSheetPopup$lambda$5 = ModalBottomSheet_androidKt.ModalBottomSheetPopup$lambda$5(state);
                            ModalBottomSheetPopup$lambda$5.invoke($composer3, 0);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            $composer3.endReplaceableGroup();
                            $composer3.endNode();
                            $composer3.endReplaceableGroup();
                            $composer3.endReplaceableGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }));
                value$iv$iv = $this$ModalBottomSheetPopup_u24lambda_u247_u24lambda_u246;
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            final ModalBottomSheetWindow modalBottomSheetWindow = (ModalBottomSheetWindow) value$iv$iv;
            EffectsKt.DisposableEffect(modalBottomSheetWindow, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                    Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                    ModalBottomSheetWindow.this.show();
                    final ModalBottomSheetWindow modalBottomSheetWindow2 = ModalBottomSheetWindow.this;
                    return new DisposableEffectResult() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            ModalBottomSheetWindow.this.disposeComposition();
                            ModalBottomSheetWindow.this.dismiss();
                        }
                    };
                }
            }, $composer2, 8);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$ModalBottomSheetPopup$2
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
                ModalBottomSheet_androidKt.ModalBottomSheetPopup(onDismissRequest, windowInsets, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function2<Composer, Integer, Unit> ModalBottomSheetPopup$lambda$5(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        Object thisObj$iv = state.getValue();
        return (Function2) thisObj$iv;
    }
}
