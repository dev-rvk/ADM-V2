package androidx.compose.ui.geometry;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

/* compiled from: Size.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 32\u00020\u0001:\u00013B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0016\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\b\u0017\u0010\u000bJ\u0010\u0010\u0018\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\b\u0019\u0010\u000bJ*\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020'HÖ\u0001¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\"H\u0007¢\u0006\u0004\b+\u0010,J!\u0010-\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0007H\u0087\u0002ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b.\u0010 J\u000f\u0010/\u001a\u000200H\u0016¢\u0006\u0004\b1\u00102R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000b\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00064"}, d2 = {"Landroidx/compose/ui/geometry/Size;", "", "packedValue", "", "constructor-impl", "(J)J", "height", "", "getHeight$annotations", "()V", "getHeight-impl", "(J)F", "maxDimension", "getMaxDimension$annotations", "getMaxDimension-impl", "minDimension", "getMinDimension$annotations", "getMinDimension-impl", "getPackedValue$annotations", "width", "getWidth$annotations", "getWidth-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-xjbvk4A", "(JFF)J", "div", "operand", "div-7Ah8Wj8", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "isEmpty", "isEmpty-impl", "(J)Z", "times", "times-7Ah8Wj8", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
/* loaded from: classes.dex */
public final class Size {
    private final long packedValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = SizeKt.Size(0.0f, 0.0f);
    private static final long Unspecified = SizeKt.Size(Float.NaN, Float.NaN);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Size m2767boximpl(long j) {
        return new Size(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m2770constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2774equalsimpl(long j, Object obj) {
        return (obj instanceof Size) && j == ((Size) obj).getPackedValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2775equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getHeight$annotations() {
    }

    public static /* synthetic */ void getMaxDimension$annotations() {
    }

    public static /* synthetic */ void getMinDimension$annotations() {
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    public static /* synthetic */ void getWidth$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2780hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m2774equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m2780hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ Size(long packedValue) {
        this.packedValue = packedValue;
    }

    /* renamed from: getWidth-impl, reason: not valid java name */
    public static final float m2779getWidthimpl(long arg0) {
        if (!(arg0 != Unspecified)) {
            throw new IllegalStateException("Size is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (arg0 >> 32));
    }

    /* renamed from: getHeight-impl, reason: not valid java name */
    public static final float m2776getHeightimpl(long arg0) {
        if (!(arg0 != Unspecified)) {
            throw new IllegalStateException("Size is unspecified".toString());
        }
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (4294967295L & arg0));
    }

    /* renamed from: component1-impl, reason: not valid java name */
    public static final float m2768component1impl(long arg0) {
        return m2779getWidthimpl(arg0);
    }

    /* renamed from: component2-impl, reason: not valid java name */
    public static final float m2769component2impl(long arg0) {
        return m2776getHeightimpl(arg0);
    }

    /* renamed from: copy-xjbvk4A, reason: not valid java name */
    public static final long m2771copyxjbvk4A(long arg0, float width, float height) {
        return SizeKt.Size(width, height);
    }

    /* renamed from: copy-xjbvk4A$default, reason: not valid java name */
    public static /* synthetic */ long m2772copyxjbvk4A$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m2779getWidthimpl(j);
        }
        if ((i & 2) != 0) {
            f2 = m2776getHeightimpl(j);
        }
        return m2771copyxjbvk4A(j, f, f2);
    }

    /* compiled from: Size.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R'\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R'\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\f"}, d2 = {"Landroidx/compose/ui/geometry/Size$Companion;", "", "()V", "Unspecified", "Landroidx/compose/ui/geometry/Size;", "getUnspecified-NH-jbRc$annotations", "getUnspecified-NH-jbRc", "()J", "J", "Zero", "getZero-NH-jbRc$annotations", "getZero-NH-jbRc", "ui-geometry_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getUnspecified-NH-jbRc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2785getUnspecifiedNHjbRc$annotations() {
        }

        /* renamed from: getZero-NH-jbRc$annotations, reason: not valid java name */
        public static /* synthetic */ void m2786getZeroNHjbRc$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getZero-NH-jbRc, reason: not valid java name */
        public final long m2788getZeroNHjbRc() {
            return Size.Zero;
        }

        /* renamed from: getUnspecified-NH-jbRc, reason: not valid java name */
        public final long m2787getUnspecifiedNHjbRc() {
            return Size.Unspecified;
        }
    }

    /* renamed from: isEmpty-impl, reason: not valid java name */
    public static final boolean m2781isEmptyimpl(long arg0) {
        return m2779getWidthimpl(arg0) <= 0.0f || m2776getHeightimpl(arg0) <= 0.0f;
    }

    /* renamed from: times-7Ah8Wj8, reason: not valid java name */
    public static final long m2782times7Ah8Wj8(long arg0, float operand) {
        return SizeKt.Size(m2779getWidthimpl(arg0) * operand, m2776getHeightimpl(arg0) * operand);
    }

    /* renamed from: div-7Ah8Wj8, reason: not valid java name */
    public static final long m2773div7Ah8Wj8(long arg0, float operand) {
        return SizeKt.Size(m2779getWidthimpl(arg0) / operand, m2776getHeightimpl(arg0) / operand);
    }

    /* renamed from: getMinDimension-impl, reason: not valid java name */
    public static final float m2778getMinDimensionimpl(long arg0) {
        return Math.min(Math.abs(m2779getWidthimpl(arg0)), Math.abs(m2776getHeightimpl(arg0)));
    }

    /* renamed from: getMaxDimension-impl, reason: not valid java name */
    public static final float m2777getMaxDimensionimpl(long arg0) {
        return Math.max(Math.abs(m2779getWidthimpl(arg0)), Math.abs(m2776getHeightimpl(arg0)));
    }

    public String toString() {
        return m2783toStringimpl(this.packedValue);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2783toStringimpl(long arg0) {
        if (arg0 != INSTANCE.m2787getUnspecifiedNHjbRc()) {
            return "Size(" + GeometryUtilsKt.toStringAsFixed(m2779getWidthimpl(arg0), 1) + ", " + GeometryUtilsKt.toStringAsFixed(m2776getHeightimpl(arg0), 1) + ')';
        }
        return "Size.Unspecified";
    }
}
