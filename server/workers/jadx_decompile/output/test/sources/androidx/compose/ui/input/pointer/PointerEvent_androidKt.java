package androidx.compose.ui.input.pointer;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: PointerEvent.android.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u000b\u001a\u0010\u0010$\u001a\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0002\u0010%\u001a\u0017\u0010&\u001a\u00020'*\u00020\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a\u0017\u0010*\u001a\u00020'*\u00020\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010)\u001a\u001f\u0010,\u001a\u00020\u0001*\u00020\u00022\u0006\u0010-\u001a\u00020'ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010/\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00068Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004\"\u0018\u0010\b\u001a\u00020\u0001*\u00020\u00068Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\t\u0010\u0004\"\u0018\u0010\n\u001a\u00020\u0001*\u00020\u00028Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0004\"\u0018\u0010\f\u001a\u00020\u0001*\u00020\u00068Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\r\u0010\u0004\"\u0018\u0010\u000e\u001a\u00020\u0001*\u00020\u00068Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0004\"\u0018\u0010\u0010\u001a\u00020\u0001*\u00020\u00028Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0004\"\u0018\u0010\u0012\u001a\u00020\u0001*\u00020\u00068Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0004\"\u0018\u0010\u0014\u001a\u00020\u0001*\u00020\u00068Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0004\"\u0018\u0010\u0016\u001a\u00020\u0001*\u00020\u00068Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0004\"\u0018\u0010\u0018\u001a\u00020\u0001*\u00020\u00028Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0004\"\u0018\u0010\u001a\u001a\u00020\u0001*\u00020\u00068Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0004\"\u0018\u0010\u001c\u001a\u00020\u0001*\u00020\u00028Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0004\"\u0018\u0010\u001e\u001a\u00020\u0001*\u00020\u00068Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0004\"\u0018\u0010 \u001a\u00020\u0001*\u00020\u00068Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b!\u0010\u0004\"\u0018\u0010\"\u001a\u00020\u0001*\u00020\u00028Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b#\u0010\u0004*\f\b\u0000\u00100\"\u00020'2\u00020'*\f\b\u0000\u00101\"\u00020'2\u00020'\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00062"}, d2 = {"areAnyPressed", "", "Landroidx/compose/ui/input/pointer/PointerButtons;", "getAreAnyPressed-aHzCx-E", "(I)Z", "isAltGraphPressed", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "isAltGraphPressed-5xRPYO0", "isAltPressed", "isAltPressed-5xRPYO0", "isBackPressed", "isBackPressed-aHzCx-E", "isCapsLockOn", "isCapsLockOn-5xRPYO0", "isCtrlPressed", "isCtrlPressed-5xRPYO0", "isForwardPressed", "isForwardPressed-aHzCx-E", "isFunctionPressed", "isFunctionPressed-5xRPYO0", "isMetaPressed", "isMetaPressed-5xRPYO0", "isNumLockOn", "isNumLockOn-5xRPYO0", "isPrimaryPressed", "isPrimaryPressed-aHzCx-E", "isScrollLockOn", "isScrollLockOn-5xRPYO0", "isSecondaryPressed", "isSecondaryPressed-aHzCx-E", "isShiftPressed", "isShiftPressed-5xRPYO0", "isSymPressed", "isSymPressed-5xRPYO0", "isTertiaryPressed", "isTertiaryPressed-aHzCx-E", "EmptyPointerKeyboardModifiers", "()I", "indexOfFirstPressed", "", "indexOfFirstPressed-aHzCx-E", "(I)I", "indexOfLastPressed", "indexOfLastPressed-aHzCx-E", "isPressed", "buttonIndex", "isPressed-bNIWhpI", "(II)Z", "NativePointerButtons", "NativePointerKeyboardModifiers", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PointerEvent_androidKt {
    public static final int EmptyPointerKeyboardModifiers() {
        return PointerKeyboardModifiers.m4130constructorimpl(0);
    }

    /* renamed from: isPrimaryPressed-aHzCx-E, reason: not valid java name */
    public static final boolean m4042isPrimaryPressedaHzCxE(int $this$isPrimaryPressed) {
        return ($this$isPrimaryPressed & 33) != 0;
    }

    /* renamed from: isSecondaryPressed-aHzCx-E, reason: not valid java name */
    public static final boolean m4044isSecondaryPressedaHzCxE(int $this$isSecondaryPressed) {
        return ($this$isSecondaryPressed & 66) != 0;
    }

    /* renamed from: isTertiaryPressed-aHzCx-E, reason: not valid java name */
    public static final boolean m4047isTertiaryPressedaHzCxE(int $this$isTertiaryPressed) {
        return ($this$isTertiaryPressed & 4) != 0;
    }

    /* renamed from: isBackPressed-aHzCx-E, reason: not valid java name */
    public static final boolean m4034isBackPressedaHzCxE(int $this$isBackPressed) {
        return ($this$isBackPressed & 8) != 0;
    }

    /* renamed from: isForwardPressed-aHzCx-E, reason: not valid java name */
    public static final boolean m4037isForwardPressedaHzCxE(int $this$isForwardPressed) {
        return ($this$isForwardPressed & 16) != 0;
    }

    /* renamed from: isPressed-bNIWhpI, reason: not valid java name */
    public static final boolean m4041isPressedbNIWhpI(int $this$isPressed_u2dbNIWhpI, int buttonIndex) {
        switch (buttonIndex) {
            case 0:
                return m4042isPrimaryPressedaHzCxE($this$isPressed_u2dbNIWhpI);
            case 1:
                return m4044isSecondaryPressedaHzCxE($this$isPressed_u2dbNIWhpI);
            case 2:
            case 3:
            case 4:
                return ((1 << buttonIndex) & $this$isPressed_u2dbNIWhpI) != 0;
            default:
                return ((1 << (buttonIndex + 2)) & $this$isPressed_u2dbNIWhpI) != 0;
        }
    }

    /* renamed from: getAreAnyPressed-aHzCx-E, reason: not valid java name */
    public static final boolean m4029getAreAnyPressedaHzCxE(int $this$areAnyPressed) {
        return $this$areAnyPressed != 0;
    }

    /* renamed from: indexOfFirstPressed-aHzCx-E, reason: not valid java name */
    public static final int m4030indexOfFirstPressedaHzCxE(int $this$indexOfFirstPressed_u2daHzCx_u2dE) {
        if ($this$indexOfFirstPressed_u2daHzCx_u2dE == 0) {
            return -1;
        }
        int index = 0;
        for (int shifted = (($this$indexOfFirstPressed_u2daHzCx_u2dE & 96) >>> 5) | ($this$indexOfFirstPressed_u2daHzCx_u2dE & (-97)); (shifted & 1) == 0; shifted >>>= 1) {
            index++;
        }
        return index;
    }

    /* renamed from: indexOfLastPressed-aHzCx-E, reason: not valid java name */
    public static final int m4031indexOfLastPressedaHzCxE(int $this$indexOfLastPressed_u2daHzCx_u2dE) {
        int index = -1;
        for (int shifted = (($this$indexOfLastPressed_u2daHzCx_u2dE & 96) >>> 5) | ($this$indexOfLastPressed_u2daHzCx_u2dE & (-97)); shifted != 0; shifted >>>= 1) {
            index++;
        }
        return index;
    }

    /* renamed from: isCtrlPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m4036isCtrlPressed5xRPYO0(int $this$isCtrlPressed) {
        return ($this$isCtrlPressed & 4096) != 0;
    }

    /* renamed from: isMetaPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m4039isMetaPressed5xRPYO0(int $this$isMetaPressed) {
        return (65536 & $this$isMetaPressed) != 0;
    }

    /* renamed from: isAltPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m4033isAltPressed5xRPYO0(int $this$isAltPressed) {
        return ($this$isAltPressed & 2) != 0;
    }

    /* renamed from: isAltGraphPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m4032isAltGraphPressed5xRPYO0(int $this$isAltGraphPressed) {
        return false;
    }

    /* renamed from: isSymPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m4046isSymPressed5xRPYO0(int $this$isSymPressed) {
        return ($this$isSymPressed & 4) != 0;
    }

    /* renamed from: isShiftPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m4045isShiftPressed5xRPYO0(int $this$isShiftPressed) {
        return ($this$isShiftPressed & 1) != 0;
    }

    /* renamed from: isFunctionPressed-5xRPYO0, reason: not valid java name */
    public static final boolean m4038isFunctionPressed5xRPYO0(int $this$isFunctionPressed) {
        return ($this$isFunctionPressed & 8) != 0;
    }

    /* renamed from: isCapsLockOn-5xRPYO0, reason: not valid java name */
    public static final boolean m4035isCapsLockOn5xRPYO0(int $this$isCapsLockOn) {
        return (1048576 & $this$isCapsLockOn) != 0;
    }

    /* renamed from: isScrollLockOn-5xRPYO0, reason: not valid java name */
    public static final boolean m4043isScrollLockOn5xRPYO0(int $this$isScrollLockOn) {
        return (4194304 & $this$isScrollLockOn) != 0;
    }

    /* renamed from: isNumLockOn-5xRPYO0, reason: not valid java name */
    public static final boolean m4040isNumLockOn5xRPYO0(int $this$isNumLockOn) {
        return (2097152 & $this$isNumLockOn) != 0;
    }
}
