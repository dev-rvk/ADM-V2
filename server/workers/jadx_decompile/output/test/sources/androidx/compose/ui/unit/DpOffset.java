package androidx.compose.ui.unit;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

/* compiled from: Dp.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 %2\u00020\u0001:\u0001%B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\tø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u001e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u001eJ\u000f\u0010!\u001a\u00020\"H\u0017¢\u0006\u0004\b#\u0010$R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R#\u0010\b\u001a\u00020\t8FX\u0087\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\fR#\u0010\r\u001a\u00020\t8FX\u0087\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\f\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, d2 = {"Landroidx/compose/ui/unit/DpOffset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "x", "Landroidx/compose/ui/unit/Dp;", "getX-D9Ej5fM$annotations", "getX-D9Ej5fM", "(J)F", "y", "getY-D9Ej5fM$annotations", "getY-D9Ej5fM", "copy", "copy-tPigGR8", "(JFF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "minus", "minus-CB-Mgk4", "(JJ)J", "plus", "plus-CB-Mgk4", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
/* loaded from: classes.dex */
public final class DpOffset {
    private final long packedValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = DpKt.m5239DpOffsetYgX7TsA(Dp.m5218constructorimpl(0), Dp.m5218constructorimpl(0));
    private static final long Unspecified = DpKt.m5239DpOffsetYgX7TsA(Dp.INSTANCE.m5238getUnspecifiedD9Ej5fM(), Dp.INSTANCE.m5238getUnspecifiedD9Ej5fM());

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpOffset m5273boximpl(long j) {
        return new DpOffset(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m5274constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5277equalsimpl(long j, Object obj) {
        return (obj instanceof DpOffset) && j == ((DpOffset) obj).getPackedValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5278equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* renamed from: getX-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m5280getXD9Ej5fM$annotations() {
    }

    /* renamed from: getY-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m5282getYD9Ej5fM$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m5283hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m5277equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m5283hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ DpOffset(long packedValue) {
        this.packedValue = packedValue;
    }

    /* renamed from: getX-D9Ej5fM, reason: not valid java name */
    public static final float m5279getXD9Ej5fM(long arg0) {
        if (!(arg0 != Unspecified)) {
            throw new IllegalStateException("DpOffset is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        float $this$dp$iv = Float.intBitsToFloat((int) (arg0 >> 32));
        return Dp.m5218constructorimpl($this$dp$iv);
    }

    /* renamed from: getY-D9Ej5fM, reason: not valid java name */
    public static final float m5281getYD9Ej5fM(long arg0) {
        if (!(arg0 != Unspecified)) {
            throw new IllegalStateException("DpOffset is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        float $this$dp$iv = Float.intBitsToFloat((int) (4294967295L & arg0));
        return Dp.m5218constructorimpl($this$dp$iv);
    }

    /* renamed from: copy-tPigGR8, reason: not valid java name */
    public static final long m5275copytPigGR8(long arg0, float x, float y) {
        return DpKt.m5239DpOffsetYgX7TsA(x, y);
    }

    /* renamed from: copy-tPigGR8$default, reason: not valid java name */
    public static /* synthetic */ long m5276copytPigGR8$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m5279getXD9Ej5fM(j);
        }
        if ((i & 2) != 0) {
            f2 = m5281getYD9Ej5fM(j);
        }
        return m5275copytPigGR8(j, f, f2);
    }

    /* renamed from: minus-CB-Mgk4, reason: not valid java name */
    public static final long m5284minusCBMgk4(long arg0, long other) {
        float arg0$iv = m5279getXD9Ej5fM(arg0);
        float other$iv = m5279getXD9Ej5fM(other);
        float arg0$iv2 = Dp.m5218constructorimpl(arg0$iv - other$iv);
        float arg0$iv3 = m5281getYD9Ej5fM(arg0);
        float other$iv2 = m5281getYD9Ej5fM(other);
        return DpKt.m5239DpOffsetYgX7TsA(arg0$iv2, Dp.m5218constructorimpl(arg0$iv3 - other$iv2));
    }

    /* renamed from: plus-CB-Mgk4, reason: not valid java name */
    public static final long m5285plusCBMgk4(long arg0, long other) {
        float arg0$iv = m5279getXD9Ej5fM(arg0);
        float other$iv = m5279getXD9Ej5fM(other);
        float arg0$iv2 = Dp.m5218constructorimpl(arg0$iv + other$iv);
        float arg0$iv3 = m5281getYD9Ej5fM(arg0);
        float other$iv2 = m5281getYD9Ej5fM(other);
        return DpKt.m5239DpOffsetYgX7TsA(arg0$iv2, Dp.m5218constructorimpl(arg0$iv3 + other$iv2));
    }

    public String toString() {
        return m5286toStringimpl(this.packedValue);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m5286toStringimpl(long arg0) {
        if (arg0 != INSTANCE.m5288getUnspecifiedRKDOV3M()) {
            return '(' + ((Object) Dp.m5229toStringimpl(m5279getXD9Ej5fM(arg0))) + ", " + ((Object) Dp.m5229toStringimpl(m5281getYD9Ej5fM(arg0))) + ')';
        }
        return "DpOffset.Unspecified";
    }

    /* compiled from: Dp.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Landroidx/compose/ui/unit/DpOffset$Companion;", "", "()V", "Unspecified", "Landroidx/compose/ui/unit/DpOffset;", "getUnspecified-RKDOV3M", "()J", "J", "Zero", "getZero-RKDOV3M", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getZero-RKDOV3M, reason: not valid java name */
        public final long m5289getZeroRKDOV3M() {
            return DpOffset.Zero;
        }

        /* renamed from: getUnspecified-RKDOV3M, reason: not valid java name */
        public final long m5288getUnspecifiedRKDOV3M() {
            return DpOffset.Unspecified;
        }
    }
}
