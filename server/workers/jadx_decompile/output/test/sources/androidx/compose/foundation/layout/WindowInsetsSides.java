package androidx.compose.foundation.layout;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowInsets.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087@\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0014\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0000H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005J\u001e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsSides;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hasAny", "sides", "hasAny-bkgdKaI$foundation_layout_release", "(II)Z", "hashCode", "hashCode-impl", "plus", "plus-gK_yJZ4", "(II)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "valueToString", "valueToString-impl", "Companion", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
/* loaded from: classes.dex */
public final class WindowInsetsSides {
    private final int value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int AllowLeftInLtr = m563constructorimpl(8);
    private static final int AllowRightInLtr = m563constructorimpl(4);
    private static final int AllowLeftInRtl = m563constructorimpl(2);
    private static final int AllowRightInRtl = m563constructorimpl(1);
    private static final int Start = m568plusgK_yJZ4(AllowLeftInLtr, AllowRightInRtl);
    private static final int End = m568plusgK_yJZ4(AllowRightInLtr, AllowLeftInRtl);
    private static final int Top = m563constructorimpl(16);
    private static final int Bottom = m563constructorimpl(32);
    private static final int Left = m568plusgK_yJZ4(AllowLeftInLtr, AllowLeftInRtl);
    private static final int Right = m568plusgK_yJZ4(AllowRightInLtr, AllowRightInRtl);
    private static final int Horizontal = m568plusgK_yJZ4(Left, Right);
    private static final int Vertical = m568plusgK_yJZ4(Top, Bottom);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ WindowInsetsSides m562boximpl(int i) {
        return new WindowInsetsSides(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m563constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m564equalsimpl(int i, Object obj) {
        return (obj instanceof WindowInsetsSides) && i == ((WindowInsetsSides) obj).getValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m565equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m567hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m564equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m567hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    private /* synthetic */ WindowInsetsSides(int value) {
        this.value = value;
    }

    /* renamed from: plus-gK_yJZ4, reason: not valid java name */
    public static final int m568plusgK_yJZ4(int arg0, int sides) {
        return m563constructorimpl(arg0 | sides);
    }

    /* renamed from: hasAny-bkgdKaI$foundation_layout_release, reason: not valid java name */
    public static final boolean m566hasAnybkgdKaI$foundation_layout_release(int arg0, int sides) {
        return (arg0 & sides) != 0;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m569toStringimpl(int arg0) {
        return "WindowInsetsSides(" + m570valueToStringimpl(arg0) + ')';
    }

    public String toString() {
        return m569toStringimpl(this.value);
    }

    /* renamed from: valueToString-impl, reason: not valid java name */
    private static final String m570valueToStringimpl(int arg0) {
        StringBuilder $this$valueToString_impl_u24lambda_u240 = new StringBuilder();
        if ((Start & arg0) == Start) {
            valueToString_impl$lambda$0$appendPlus($this$valueToString_impl_u24lambda_u240, "Start");
        }
        if ((Left & arg0) == Left) {
            valueToString_impl$lambda$0$appendPlus($this$valueToString_impl_u24lambda_u240, "Left");
        }
        if ((Top & arg0) == Top) {
            valueToString_impl$lambda$0$appendPlus($this$valueToString_impl_u24lambda_u240, "Top");
        }
        if ((End & arg0) == End) {
            valueToString_impl$lambda$0$appendPlus($this$valueToString_impl_u24lambda_u240, "End");
        }
        if ((Right & arg0) == Right) {
            valueToString_impl$lambda$0$appendPlus($this$valueToString_impl_u24lambda_u240, "Right");
        }
        if ((Bottom & arg0) == Bottom) {
            valueToString_impl$lambda$0$appendPlus($this$valueToString_impl_u24lambda_u240, "Bottom");
        }
        String sb = $this$valueToString_impl_u24lambda_u240.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().apply(builderAction).toString()");
        return sb;
    }

    private static final void valueToString_impl$lambda$0$appendPlus(StringBuilder $this_buildString, String text) {
        if ($this_buildString.length() > 0) {
            $this_buildString.append('+');
        }
        $this_buildString.append(text);
    }

    /* compiled from: WindowInsets.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001f\u0010\u0003\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001f\u0010\b\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001f\u0010\n\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u001f\u0010\f\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0017\u0010\u0006R\u001c\u0010\u0018\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0019\u0010\u0006R\u001c\u0010\u001a\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001d\u0010\u0006\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/layout/WindowInsetsSides$Companion;", "", "()V", "AllowLeftInLtr", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "getAllowLeftInLtr-JoeWqyM$foundation_layout_release", "()I", "I", "AllowLeftInRtl", "getAllowLeftInRtl-JoeWqyM$foundation_layout_release", "AllowRightInLtr", "getAllowRightInLtr-JoeWqyM$foundation_layout_release", "AllowRightInRtl", "getAllowRightInRtl-JoeWqyM$foundation_layout_release", "Bottom", "getBottom-JoeWqyM", "End", "getEnd-JoeWqyM", "Horizontal", "getHorizontal-JoeWqyM", "Left", "getLeft-JoeWqyM", "Right", "getRight-JoeWqyM", "Start", "getStart-JoeWqyM", "Top", "getTop-JoeWqyM", "Vertical", "getVertical-JoeWqyM", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getAllowLeftInLtr-JoeWqyM$foundation_layout_release, reason: not valid java name */
        public final int m572getAllowLeftInLtrJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowLeftInLtr;
        }

        /* renamed from: getAllowRightInLtr-JoeWqyM$foundation_layout_release, reason: not valid java name */
        public final int m574getAllowRightInLtrJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowRightInLtr;
        }

        /* renamed from: getAllowLeftInRtl-JoeWqyM$foundation_layout_release, reason: not valid java name */
        public final int m573getAllowLeftInRtlJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowLeftInRtl;
        }

        /* renamed from: getAllowRightInRtl-JoeWqyM$foundation_layout_release, reason: not valid java name */
        public final int m575getAllowRightInRtlJoeWqyM$foundation_layout_release() {
            return WindowInsetsSides.AllowRightInRtl;
        }

        /* renamed from: getStart-JoeWqyM, reason: not valid java name */
        public final int m581getStartJoeWqyM() {
            return WindowInsetsSides.Start;
        }

        /* renamed from: getEnd-JoeWqyM, reason: not valid java name */
        public final int m577getEndJoeWqyM() {
            return WindowInsetsSides.End;
        }

        /* renamed from: getTop-JoeWqyM, reason: not valid java name */
        public final int m582getTopJoeWqyM() {
            return WindowInsetsSides.Top;
        }

        /* renamed from: getBottom-JoeWqyM, reason: not valid java name */
        public final int m576getBottomJoeWqyM() {
            return WindowInsetsSides.Bottom;
        }

        /* renamed from: getLeft-JoeWqyM, reason: not valid java name */
        public final int m579getLeftJoeWqyM() {
            return WindowInsetsSides.Left;
        }

        /* renamed from: getRight-JoeWqyM, reason: not valid java name */
        public final int m580getRightJoeWqyM() {
            return WindowInsetsSides.Right;
        }

        /* renamed from: getHorizontal-JoeWqyM, reason: not valid java name */
        public final int m578getHorizontalJoeWqyM() {
            return WindowInsetsSides.Horizontal;
        }

        /* renamed from: getVertical-JoeWqyM, reason: not valid java name */
        public final int m583getVerticalJoeWqyM() {
            return WindowInsetsSides.Vertical;
        }
    }
}
