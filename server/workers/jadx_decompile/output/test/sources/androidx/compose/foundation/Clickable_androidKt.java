package androidx.compose.foundation;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Clickable.android.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\r\u001a\u00020\u0005*\u00020\u000eH\u0000\u001a\f\u0010\u000f\u001a\u00020\u0005*\u00020\u0010H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\u0004\u001a\u00020\u0005*\u00020\u00068@X\u0080\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u001b\u0010\t\u001a\u00020\u0005*\u00020\u00068BX\u0082\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\n\u0010\b\"\u001b\u0010\u000b\u001a\u00020\u0005*\u00020\u00068@X\u0080\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\f\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"TapIndicationDelay", "", "getTapIndicationDelay", "()J", "isClick", "", "Landroidx/compose/ui/input/key/KeyEvent;", "isClick-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "isEnter", "isEnter-ZmokQxo", "isPress", "isPress-ZmokQxo", "isComposeRootInScrollableContainer", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "isInScrollableViewGroup", "Landroid/view/View;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class Clickable_androidKt {
    private static final long TapIndicationDelay = ViewConfiguration.getTapTimeout();

    public static final boolean isComposeRootInScrollableContainer(CompositionLocalConsumerModifierNode $this$isComposeRootInScrollableContainer) {
        Intrinsics.checkNotNullParameter($this$isComposeRootInScrollableContainer, "<this>");
        return isInScrollableViewGroup((View) CompositionLocalConsumerModifierNodeKt.currentValueOf($this$isComposeRootInScrollableContainer, AndroidCompositionLocals_androidKt.getLocalView()));
    }

    private static final boolean isInScrollableViewGroup(View $this$isInScrollableViewGroup) {
        for (ViewParent p = $this$isInScrollableViewGroup.getParent(); p != null && (p instanceof ViewGroup); p = ((ViewGroup) p).getParent()) {
            if (((ViewGroup) p).shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    public static final long getTapIndicationDelay() {
        return TapIndicationDelay;
    }

    /* renamed from: isPress-ZmokQxo, reason: not valid java name */
    public static final boolean m211isPressZmokQxo(KeyEvent isPress) {
        Intrinsics.checkNotNullParameter(isPress, "$this$isPress");
        return KeyEventType.m3928equalsimpl0(KeyEvent_androidKt.m3936getTypeZmokQxo(isPress), KeyEventType.INSTANCE.m3932getKeyDownCS__XNY()) && m210isEnterZmokQxo(isPress);
    }

    /* renamed from: isClick-ZmokQxo, reason: not valid java name */
    public static final boolean m209isClickZmokQxo(KeyEvent isClick) {
        Intrinsics.checkNotNullParameter(isClick, "$this$isClick");
        return KeyEventType.m3928equalsimpl0(KeyEvent_androidKt.m3936getTypeZmokQxo(isClick), KeyEventType.INSTANCE.m3933getKeyUpCS__XNY()) && m210isEnterZmokQxo(isClick);
    }

    /* renamed from: isEnter-ZmokQxo, reason: not valid java name */
    private static final boolean m210isEnterZmokQxo(KeyEvent $this$isEnter) {
        switch (Key_androidKt.m3942getNativeKeyCodeYVgTNJs(KeyEvent_androidKt.m3935getKeyZmokQxo($this$isEnter))) {
            case 23:
            case 66:
            case 160:
                return true;
            default:
                return false;
        }
    }
}
