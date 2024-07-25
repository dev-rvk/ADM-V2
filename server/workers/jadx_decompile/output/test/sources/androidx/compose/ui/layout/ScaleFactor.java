package androidx.compose.ui.layout;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

/* compiled from: ScaleFactor.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 *2\u00020\u0001:\u0001*B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0011\u0010\fJ\u0010\u0010\u0012\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0013\u0010\fJ*\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\tø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0087\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J!\u0010$\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0087\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b%\u0010\u001aJ\u000f\u0010&\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\f\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006+"}, d2 = {"Landroidx/compose/ui/layout/ScaleFactor;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "scaleX", "", "getScaleX$annotations", "getScaleX-impl", "(J)F", "scaleY", "getScaleY$annotations", "getScaleY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-8GGzs04", "(JFF)J", "div", "operand", "div-44nBxM0", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "times", "times-44nBxM0", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
/* loaded from: classes.dex */
public final class ScaleFactor {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Unspecified = ScaleFactorKt.ScaleFactor(Float.NaN, Float.NaN);
    private final long packedValue;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ScaleFactor m4253boximpl(long j) {
        return new ScaleFactor(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m4256constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4260equalsimpl(long j, Object obj) {
        return (obj instanceof ScaleFactor) && j == ((ScaleFactor) obj).getPackedValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4261equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    public static /* synthetic */ void getScaleX$annotations() {
    }

    public static /* synthetic */ void getScaleY$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m4264hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m4260equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m4264hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ ScaleFactor(long packedValue) {
        this.packedValue = packedValue;
    }

    /* renamed from: getScaleX-impl, reason: not valid java name */
    public static final float m4262getScaleXimpl(long arg0) {
        if (!(arg0 != Unspecified)) {
            throw new IllegalStateException("ScaleFactor is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (arg0 >> 32));
    }

    /* renamed from: getScaleY-impl, reason: not valid java name */
    public static final float m4263getScaleYimpl(long arg0) {
        if (!(arg0 != Unspecified)) {
            throw new IllegalStateException("ScaleFactor is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (4294967295L & arg0));
    }

    /* renamed from: component1-impl, reason: not valid java name */
    public static final float m4254component1impl(long arg0) {
        return m4262getScaleXimpl(arg0);
    }

    /* renamed from: component2-impl, reason: not valid java name */
    public static final float m4255component2impl(long arg0) {
        return m4263getScaleYimpl(arg0);
    }

    /* renamed from: copy-8GGzs04, reason: not valid java name */
    public static final long m4257copy8GGzs04(long arg0, float scaleX, float scaleY) {
        return ScaleFactorKt.ScaleFactor(scaleX, scaleY);
    }

    /* renamed from: copy-8GGzs04$default, reason: not valid java name */
    public static /* synthetic */ long m4258copy8GGzs04$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m4262getScaleXimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m4263getScaleYimpl(j);
        }
        return m4257copy8GGzs04(j, f, f2);
    }

    /* renamed from: times-44nBxM0, reason: not valid java name */
    public static final long m4265times44nBxM0(long arg0, float operand) {
        return ScaleFactorKt.ScaleFactor(m4262getScaleXimpl(arg0) * operand, m4263getScaleYimpl(arg0) * operand);
    }

    /* renamed from: div-44nBxM0, reason: not valid java name */
    public static final long m4259div44nBxM0(long arg0, float operand) {
        return ScaleFactorKt.ScaleFactor(m4262getScaleXimpl(arg0) / operand, m4263getScaleYimpl(arg0) / operand);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m4266toStringimpl(long arg0) {
        float roundToTenths;
        float roundToTenths2;
        StringBuilder append = new StringBuilder().append("ScaleFactor(");
        roundToTenths = ScaleFactorKt.roundToTenths(m4262getScaleXimpl(arg0));
        StringBuilder append2 = append.append(roundToTenths).append(", ");
        roundToTenths2 = ScaleFactorKt.roundToTenths(m4263getScaleYimpl(arg0));
        return append2.append(roundToTenths2).append(')').toString();
    }

    public String toString() {
        return m4266toStringimpl(this.packedValue);
    }

    /* compiled from: ScaleFactor.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R'\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\t"}, d2 = {"Landroidx/compose/ui/layout/ScaleFactor$Companion;", "", "()V", "Unspecified", "Landroidx/compose/ui/layout/ScaleFactor;", "getUnspecified-_hLwfpc$annotations", "getUnspecified-_hLwfpc", "()J", "J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getUnspecified-_hLwfpc$annotations, reason: not valid java name */
        public static /* synthetic */ void m4268getUnspecified_hLwfpc$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getUnspecified-_hLwfpc, reason: not valid java name */
        public final long m4269getUnspecified_hLwfpc() {
            return ScaleFactor.Unspecified;
        }
    }
}
