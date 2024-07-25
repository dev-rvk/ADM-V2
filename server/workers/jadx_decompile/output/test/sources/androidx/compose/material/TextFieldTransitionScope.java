package androidx.compose.material;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: TextFieldImpl.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jµ\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2e\u0010\u000f\u001aa\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\b\fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001a²\u0006\n\u0010\u0014\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\bX\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\bX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material/TextFieldTransitionScope;", "", "()V", "Transition", "", "inputState", "Landroidx/compose/material/InputPhase;", "focusedTextStyleColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextStyleColor", "contentColor", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "showLabel", "", "content", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "labelProgress", "labelTextStyleColor", "labelContentColor", "placeholderOpacity", "Transition-DTcfvLk", "(Landroidx/compose/material/InputPhase;JJLkotlin/jvm/functions/Function3;ZLkotlin/jvm/functions/Function6;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class TextFieldTransitionScope {
    public static final TextFieldTransitionScope INSTANCE = new TextFieldTransitionScope();

    /* compiled from: TextFieldImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InputPhase.values().length];
            try {
                iArr[InputPhase.Focused.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TextFieldTransitionScope() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:93:0x02b5. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x04da  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x04e7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0391 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0355  */
    /* renamed from: Transition-DTcfvLk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m1256TransitionDTcfvLk(final androidx.compose.material.InputPhase r34, final long r35, final long r37, final kotlin.jvm.functions.Function3<? super androidx.compose.material.InputPhase, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, androidx.compose.ui.graphics.Color> r39, final boolean r40, final kotlin.jvm.functions.Function6<? super java.lang.Float, ? super androidx.compose.ui.graphics.Color, ? super androidx.compose.ui.graphics.Color, ? super java.lang.Float, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, androidx.compose.runtime.Composer r42, final int r43) {
        /*
            Method dump skipped, instructions count: 1540
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldTransitionScope.m1256TransitionDTcfvLk(androidx.compose.material.InputPhase, long, long, kotlin.jvm.functions.Function3, boolean, kotlin.jvm.functions.Function6, androidx.compose.runtime.Composer, int):void");
    }

    private static final float Transition_DTcfvLk$lambda$1(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    private static final float Transition_DTcfvLk$lambda$3(State<Float> state) {
        Object thisObj$iv = state.getValue();
        return ((Number) thisObj$iv).floatValue();
    }

    private static final long Transition_DTcfvLk$lambda$5(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m2959unboximpl();
    }

    private static final long Transition_DTcfvLk$lambda$6(State<Color> state) {
        Object thisObj$iv = state.getValue();
        return ((Color) thisObj$iv).m2959unboximpl();
    }
}
