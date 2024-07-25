package androidx.compose.ui.unit;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

/* compiled from: TextUnit.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087@\u0018\u0000 02\u00020\u0001:\u00010B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001dH\u0086\nø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ!\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0014H\u0086\nø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010 J!\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018H\u0086\nø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010!J\u001a\u0010\"\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b&\u0010'J!\u0010(\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001dH\u0086\nø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010\u001fJ!\u0010(\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0014H\u0086\nø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010 J!\u0010(\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018H\u0086\nø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010!J\u000f\u0010*\u001a\u00020+H\u0016¢\u0006\u0004\b,\u0010-J\u0019\u0010.\u001a\u00020\u0000H\u0086\nø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u00038@X\u0081\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0005R\u001a\u0010\u0010\u001a\u00020\u00118Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0005R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00061"}, d2 = {"Landroidx/compose/ui/unit/TextUnit;", "", "packedValue", "", "constructor-impl", "(J)J", "isEm", "", "isEm-impl", "(J)Z", "isSp", "isSp-impl", "rawType", "getRawType$annotations", "()V", "getRawType-impl", "type", "Landroidx/compose/ui/unit/TextUnitType;", "getType-UIouoOA", "value", "", "getValue-impl", "(J)F", "compareTo", "", "other", "compareTo--R2X_6o", "(JJ)I", "div", "", "div-kPz2Gy4", "(JD)J", "(JF)J", "(JI)J", "equals", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "(J)I", "times", "times-kPz2Gy4", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-XSAIIZE", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
/* loaded from: classes.dex */
public final class TextUnit {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TextUnitType[] TextUnitTypes = {TextUnitType.m5424boximpl(TextUnitType.INSTANCE.m5433getUnspecifiedUIouoOA()), TextUnitType.m5424boximpl(TextUnitType.INSTANCE.m5432getSpUIouoOA()), TextUnitType.m5424boximpl(TextUnitType.INSTANCE.m5431getEmUIouoOA())};
    private static final long Unspecified = TextUnitKt.pack(0, Float.NaN);
    private final long packedValue;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextUnit m5389boximpl(long j) {
        return new TextUnit(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m5391constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5395equalsimpl(long j, Object obj) {
        return (obj instanceof TextUnit) && j == ((TextUnit) obj).getPackedValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5396equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getRawType$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m5400hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m5395equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m5400hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    private /* synthetic */ TextUnit(long packedValue) {
        this.packedValue = packedValue;
    }

    /* renamed from: unaryMinus-XSAIIZE, reason: not valid java name */
    public static final long m5407unaryMinusXSAIIZE(long arg0) {
        TextUnitKt.m5412checkArithmeticR2X_6o(arg0);
        return TextUnitKt.pack(m5397getRawTypeimpl(arg0), -m5399getValueimpl(arg0));
    }

    /* renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m5393divkPz2Gy4(long arg0, float other) {
        TextUnitKt.m5412checkArithmeticR2X_6o(arg0);
        return TextUnitKt.pack(m5397getRawTypeimpl(arg0), m5399getValueimpl(arg0) / other);
    }

    /* renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m5392divkPz2Gy4(long arg0, double other) {
        TextUnitKt.m5412checkArithmeticR2X_6o(arg0);
        return TextUnitKt.pack(m5397getRawTypeimpl(arg0), (float) (m5399getValueimpl(arg0) / other));
    }

    /* renamed from: div-kPz2Gy4, reason: not valid java name */
    public static final long m5394divkPz2Gy4(long arg0, int other) {
        TextUnitKt.m5412checkArithmeticR2X_6o(arg0);
        return TextUnitKt.pack(m5397getRawTypeimpl(arg0), m5399getValueimpl(arg0) / other);
    }

    /* renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m5404timeskPz2Gy4(long arg0, float other) {
        TextUnitKt.m5412checkArithmeticR2X_6o(arg0);
        return TextUnitKt.pack(m5397getRawTypeimpl(arg0), m5399getValueimpl(arg0) * other);
    }

    /* renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m5403timeskPz2Gy4(long arg0, double other) {
        TextUnitKt.m5412checkArithmeticR2X_6o(arg0);
        return TextUnitKt.pack(m5397getRawTypeimpl(arg0), (float) (m5399getValueimpl(arg0) * other));
    }

    /* renamed from: times-kPz2Gy4, reason: not valid java name */
    public static final long m5405timeskPz2Gy4(long arg0, int other) {
        TextUnitKt.m5412checkArithmeticR2X_6o(arg0);
        return TextUnitKt.pack(m5397getRawTypeimpl(arg0), m5399getValueimpl(arg0) * other);
    }

    /* renamed from: compareTo--R2X_6o, reason: not valid java name */
    public static final int m5390compareToR2X_6o(long arg0, long other) {
        TextUnitKt.m5413checkArithmeticNB67dxo(arg0, other);
        return Float.compare(m5399getValueimpl(arg0), m5399getValueimpl(other));
    }

    public String toString() {
        return m5406toStringimpl(this.packedValue);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m5406toStringimpl(long arg0) {
        long m5398getTypeUIouoOA = m5398getTypeUIouoOA(arg0);
        return TextUnitType.m5427equalsimpl0(m5398getTypeUIouoOA, TextUnitType.INSTANCE.m5433getUnspecifiedUIouoOA()) ? "Unspecified" : TextUnitType.m5427equalsimpl0(m5398getTypeUIouoOA, TextUnitType.INSTANCE.m5432getSpUIouoOA()) ? m5399getValueimpl(arg0) + ".sp" : TextUnitType.m5427equalsimpl0(m5398getTypeUIouoOA, TextUnitType.INSTANCE.m5431getEmUIouoOA()) ? m5399getValueimpl(arg0) + ".em" : "Invalid";
    }

    /* compiled from: TextUnit.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R'\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\r\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/unit/TextUnit$Companion;", "", "()V", "TextUnitTypes", "", "Landroidx/compose/ui/unit/TextUnitType;", "getTextUnitTypes$ui_unit_release", "()[Landroidx/compose/ui/unit/TextUnitType;", "[Landroidx/compose/ui/unit/TextUnitType;", "Unspecified", "Landroidx/compose/ui/unit/TextUnit;", "getUnspecified-XSAIIZE$annotations", "getUnspecified-XSAIIZE", "()J", "J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getUnspecified-XSAIIZE$annotations, reason: not valid java name */
        public static /* synthetic */ void m5409getUnspecifiedXSAIIZE$annotations() {
        }

        private Companion() {
        }

        public final TextUnitType[] getTextUnitTypes$ui_unit_release() {
            return TextUnit.TextUnitTypes;
        }

        /* renamed from: getUnspecified-XSAIIZE, reason: not valid java name */
        public final long m5410getUnspecifiedXSAIIZE() {
            return TextUnit.Unspecified;
        }
    }

    /* renamed from: getRawType-impl, reason: not valid java name */
    public static final long m5397getRawTypeimpl(long arg0) {
        return 1095216660480L & arg0;
    }

    /* renamed from: getType-UIouoOA, reason: not valid java name */
    public static final long m5398getTypeUIouoOA(long arg0) {
        return TextUnitTypes[(int) (m5397getRawTypeimpl(arg0) >>> 32)].getType();
    }

    /* renamed from: isSp-impl, reason: not valid java name */
    public static final boolean m5402isSpimpl(long arg0) {
        return m5397getRawTypeimpl(arg0) == 4294967296L;
    }

    /* renamed from: isEm-impl, reason: not valid java name */
    public static final boolean m5401isEmimpl(long arg0) {
        return m5397getRawTypeimpl(arg0) == 8589934592L;
    }

    /* renamed from: getValue-impl, reason: not valid java name */
    public static final float m5399getValueimpl(long arg0) {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat((int) (4294967295L & arg0));
    }
}
