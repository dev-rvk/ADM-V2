package androidx.compose.ui.graphics;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.internal.view.SupportMenu;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.text.CharsKt;
import kotlin.text.Regex;

/* compiled from: Float16.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\b\u0081@\u0018\u0000 R2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001RB\u0014\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005B\u0014\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0007B\u0012\u0012\u0006\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\nJ\u0016\u0010\u0015\u001a\u00020\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\nJ\u0016\u0010\u0017\u001a\u00020\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\nJ\u001e\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b \u0010!J\u0016\u0010\"\u001a\u00020\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010\nJ\u0010\u0010$\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b%\u0010\u000eJ\r\u0010&\u001a\u00020\u001e¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u001e¢\u0006\u0004\b*\u0010(J\r\u0010+\u001a\u00020\u001e¢\u0006\u0004\b,\u0010(J\r\u0010-\u001a\u00020\u001e¢\u0006\u0004\b.\u0010(J\u0016\u0010/\u001a\u00020\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u0010\nJ\r\u00101\u001a\u00020\f¢\u0006\u0004\b2\u0010\u000eJ\r\u00103\u001a\u000204¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\u0006¢\u0006\u0004\b8\u00109J\r\u0010:\u001a\u00020\u0003¢\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020>¢\u0006\u0004\b?\u0010@J\r\u0010A\u001a\u00020\f¢\u0006\u0004\bB\u0010\u000eJ\r\u0010C\u001a\u00020D¢\u0006\u0004\bE\u0010FJ\r\u0010G\u001a\u00020\f¢\u0006\u0004\bH\u0010\u000eJ\r\u0010I\u001a\u00020\t¢\u0006\u0004\bJ\u0010\nJ\u000f\u0010K\u001a\u00020>H\u0016¢\u0006\u0004\bL\u0010@J\u0016\u0010M\u001a\u00020\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010\nJ\u001b\u0010O\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010QR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00008Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u0011\u0010\u0013\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000e\u0088\u0001\bø\u0001\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006S"}, d2 = {"Landroidx/compose/ui/graphics/Float16;", "", "value", "", "constructor-impl", "(F)S", "", "(D)S", "halfValue", "", "(S)S", "exponent", "", "getExponent-impl", "(S)I", "getHalfValue", "()S", "sign", "getSign-slo4al4", "significand", "getSignificand-impl", "absoluteValue", "absoluteValue-slo4al4", "ceil", "ceil-slo4al4", "compareTo", "other", "compareTo-41bOqos", "(SS)I", "equals", "", "", "equals-impl", "(SLjava/lang/Object;)Z", "floor", "floor-slo4al4", "hashCode", "hashCode-impl", "isFinite", "isFinite-impl", "(S)Z", "isInfinite", "isInfinite-impl", "isNaN", "isNaN-impl", "isNormalized", "isNormalized-impl", "round", "round-slo4al4", "toBits", "toBits-impl", "toByte", "", "toByte-impl", "(S)B", "toDouble", "toDouble-impl", "(S)D", "toFloat", "toFloat-impl", "(S)F", "toHexString", "", "toHexString-impl", "(S)Ljava/lang/String;", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(S)J", "toRawBits", "toRawBits-impl", "toShort", "toShort-impl", "toString", "toString-impl", "trunc", "trunc-slo4al4", "withSign", "withSign-qCeQghg", "(SS)S", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
/* loaded from: classes.dex */
public final class Float16 implements Comparable<Float16> {
    private static final int FP16_COMBINED = 32767;
    private static final int FP16_EXPONENT_BIAS = 15;
    private static final int FP16_EXPONENT_MASK = 31;
    private static final int FP16_EXPONENT_MAX = 31744;
    private static final int FP16_EXPONENT_SHIFT = 10;
    private static final int FP16_SIGNIFICAND_MASK = 1023;
    private static final int FP16_SIGN_MASK = 32768;
    private static final int FP16_SIGN_SHIFT = 15;
    private static final float FP32_DENORMAL_FLOAT;
    private static final int FP32_DENORMAL_MAGIC = 1056964608;
    private static final int FP32_EXPONENT_BIAS = 127;
    private static final int FP32_EXPONENT_MASK = 255;
    private static final int FP32_EXPONENT_SHIFT = 23;
    private static final int FP32_QNAN_MASK = 4194304;
    private static final int FP32_SIGNIFICAND_MASK = 8388607;
    private static final int FP32_SIGN_SHIFT = 31;
    public static final int MaxExponent = 15;
    public static final int MinExponent = -14;
    public static final int Size = 16;
    private final short halfValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final short Epsilon = m3054constructorimpl((short) 5120);
    private static final short LowestValue = m3054constructorimpl((short) -1025);
    private static final short MaxValue = m3054constructorimpl((short) 31743);
    private static final short MinNormal = m3054constructorimpl((short) 1024);
    private static final short MinValue = m3054constructorimpl((short) 1);
    private static final short NaN = m3054constructorimpl((short) 32256);
    private static final short NegativeInfinity = m3054constructorimpl((short) -1024);
    private static final short NegativeZero = m3054constructorimpl(ShortCompanionObject.MIN_VALUE);
    private static final short PositiveInfinity = m3054constructorimpl((short) 31744);
    private static final short PositiveZero = m3054constructorimpl((short) 0);
    private static final short One = m3053constructorimpl(1.0f);
    private static final short NegativeOne = m3053constructorimpl(-1.0f);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Float16 m3049boximpl(short s) {
        return new Float16(s);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static short m3054constructorimpl(short s) {
        return s;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3055equalsimpl(short s, Object obj) {
        return (obj instanceof Float16) && s == ((Float16) obj).m3080unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3056equalsimpl0(short s, short s2) {
        return s == s2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3061hashCodeimpl(short s) {
        return Short.hashCode(s);
    }

    public boolean equals(Object obj) {
        return m3055equalsimpl(this.halfValue, obj);
    }

    public int hashCode() {
        return m3061hashCodeimpl(this.halfValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ short m3080unboximpl() {
        return this.halfValue;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Float16 float16) {
        return m3079compareTo41bOqos(float16.m3080unboximpl());
    }

    private /* synthetic */ Float16(short halfValue) {
        this.halfValue = halfValue;
    }

    public final short getHalfValue() {
        return this.halfValue;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static short m3053constructorimpl(float value) {
        return m3054constructorimpl(INSTANCE.floatToHalf(value));
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static short m3052constructorimpl(double value) {
        return m3053constructorimpl((float) value);
    }

    /* renamed from: toByte-impl, reason: not valid java name */
    public static final byte m3068toByteimpl(short arg0) {
        return (byte) m3070toFloatimpl(arg0);
    }

    /* renamed from: toShort-impl, reason: not valid java name */
    public static final short m3075toShortimpl(short arg0) {
        return (short) m3070toFloatimpl(arg0);
    }

    /* renamed from: toInt-impl, reason: not valid java name */
    public static final int m3072toIntimpl(short arg0) {
        return (int) m3070toFloatimpl(arg0);
    }

    /* renamed from: toLong-impl, reason: not valid java name */
    public static final long m3073toLongimpl(short arg0) {
        return m3070toFloatimpl(arg0);
    }

    /* renamed from: toFloat-impl, reason: not valid java name */
    public static final float m3070toFloatimpl(short arg0) {
        int bits = 65535 & arg0;
        int s = 32768 & bits;
        int e = (bits >>> 10) & 31;
        int m = bits & FP16_SIGNIFICAND_MASK;
        int outE = 0;
        int outM = 0;
        if (e == 0) {
            if (m != 0) {
                FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
                float o = Float.intBitsToFloat(FP32_DENORMAL_MAGIC + m) - FP32_DENORMAL_FLOAT;
                return s == 0 ? o : -o;
            }
        } else {
            outM = m << 13;
            if (e == 31) {
                outE = 255;
                if (outM != 0) {
                    outM |= 4194304;
                }
            } else {
                outE = (e - 15) + 127;
            }
        }
        int out = (s << 16) | (outE << 23) | outM;
        FloatCompanionObject floatCompanionObject2 = FloatCompanionObject.INSTANCE;
        return Float.intBitsToFloat(out);
    }

    /* renamed from: toDouble-impl, reason: not valid java name */
    public static final double m3069toDoubleimpl(short arg0) {
        return m3070toFloatimpl(arg0);
    }

    /* renamed from: toBits-impl, reason: not valid java name */
    public static final int m3067toBitsimpl(short arg0) {
        if (m3064isNaNimpl(arg0)) {
            return NaN;
        }
        return 65535 & arg0;
    }

    /* renamed from: toRawBits-impl, reason: not valid java name */
    public static final int m3074toRawBitsimpl(short arg0) {
        return 65535 & arg0;
    }

    public String toString() {
        return m3076toStringimpl(this.halfValue);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3076toStringimpl(short arg0) {
        return String.valueOf(m3070toFloatimpl(arg0));
    }

    /* renamed from: compareTo-41bOqos, reason: not valid java name */
    public int m3079compareTo41bOqos(short other) {
        return m3051compareTo41bOqos(this.halfValue, other);
    }

    /* renamed from: compareTo-41bOqos, reason: not valid java name */
    public static int m3051compareTo41bOqos(short s, short s2) {
        if (m3064isNaNimpl(s)) {
            return !m3064isNaNimpl(s2) ? 1 : 0;
        }
        if (m3064isNaNimpl(s2)) {
            return -1;
        }
        return Intrinsics.compare(INSTANCE.toCompareValue(s), INSTANCE.toCompareValue(s2));
    }

    /* renamed from: getSign-slo4al4, reason: not valid java name */
    public static final short m3059getSignslo4al4(short arg0) {
        if (m3064isNaNimpl(arg0)) {
            return NaN;
        }
        return m3051compareTo41bOqos(arg0, NegativeZero) < 0 ? NegativeOne : m3051compareTo41bOqos(arg0, PositiveZero) > 0 ? One : arg0;
    }

    /* renamed from: withSign-qCeQghg, reason: not valid java name */
    public static final short m3078withSignqCeQghg(short arg0, short sign) {
        return m3054constructorimpl((short) ((32768 & sign) | (arg0 & ShortCompanionObject.MAX_VALUE)));
    }

    /* renamed from: absoluteValue-slo4al4, reason: not valid java name */
    public static final short m3048absoluteValueslo4al4(short arg0) {
        return m3054constructorimpl((short) (arg0 & ShortCompanionObject.MAX_VALUE));
    }

    /* renamed from: round-slo4al4, reason: not valid java name */
    public static final short m3066roundslo4al4(short arg0) {
        int i = SupportMenu.USER_MASK;
        int bits = arg0 & UShort.MAX_VALUE;
        int e = bits & FP16_COMBINED;
        int result = bits;
        if (e < 15360) {
            int result2 = result & 32768;
            if (e < 14336) {
                i = 0;
            }
            result = result2 | (i & 15360);
        } else if (e < 25600) {
            int e2 = 25 - (e >> 10);
            int mask = (1 << e2) - 1;
            result = (result + (1 << (e2 - 1))) & (~mask);
        }
        return m3054constructorimpl((short) result);
    }

    /* renamed from: ceil-slo4al4, reason: not valid java name */
    public static final short m3050ceilslo4al4(short arg0) {
        int bits = 65535 & arg0;
        int e = bits & FP16_COMBINED;
        int result = bits;
        if (e < 15360) {
            result = (result & 32768) | ((-((e == 0 ? 0 : 1) & (~(bits >> 15)))) & 15360);
        } else if (e < 25600) {
            int mask = (1 << (25 - (e >> 10))) - 1;
            result = (result + (mask & ((bits >> 15) - 1))) & (~mask);
        }
        return m3054constructorimpl((short) result);
    }

    /* renamed from: floor-slo4al4, reason: not valid java name */
    public static final short m3057floorslo4al4(short arg0) {
        int i = SupportMenu.USER_MASK;
        int bits = arg0 & UShort.MAX_VALUE;
        int e = bits & FP16_COMBINED;
        int result = bits;
        if (e < 15360) {
            int result2 = result & 32768;
            if (bits <= 32768) {
                i = 0;
            }
            result = result2 | (i & 15360);
        } else if (e < 25600) {
            int mask = (1 << (25 - (e >> 10))) - 1;
            result = (result + ((-(bits >> 15)) & mask)) & (~mask);
        }
        return m3054constructorimpl((short) result);
    }

    /* renamed from: trunc-slo4al4, reason: not valid java name */
    public static final short m3077truncslo4al4(short arg0) {
        int bits = 65535 & arg0;
        int e = bits & FP16_COMBINED;
        int result = bits;
        if (e < 15360) {
            result &= 32768;
        } else if (e < 25600) {
            int mask = (1 << (25 - (e >> 10))) - 1;
            result &= ~mask;
        }
        return m3054constructorimpl((short) result);
    }

    /* renamed from: getExponent-impl, reason: not valid java name */
    public static final int m3058getExponentimpl(short arg0) {
        return ((arg0 >>> 10) & 31) - 15;
    }

    /* renamed from: getSignificand-impl, reason: not valid java name */
    public static final int m3060getSignificandimpl(short arg0) {
        return arg0 & 1023;
    }

    /* renamed from: isNaN-impl, reason: not valid java name */
    public static final boolean m3064isNaNimpl(short arg0) {
        return (arg0 & ShortCompanionObject.MAX_VALUE) > FP16_EXPONENT_MAX;
    }

    /* renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m3063isInfiniteimpl(short arg0) {
        return (arg0 & ShortCompanionObject.MAX_VALUE) == FP16_EXPONENT_MAX;
    }

    /* renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m3062isFiniteimpl(short arg0) {
        return (arg0 & ShortCompanionObject.MAX_VALUE) != FP16_EXPONENT_MAX;
    }

    /* renamed from: isNormalized-impl, reason: not valid java name */
    public static final boolean m3065isNormalizedimpl(short arg0) {
        return ((arg0 & 31744) == 0 || (arg0 & 31744) == FP16_EXPONENT_MAX) ? false : true;
    }

    /* renamed from: toHexString-impl, reason: not valid java name */
    public static final String m3071toHexStringimpl(short arg0) {
        StringBuilder o = new StringBuilder();
        int bits = 65535 & arg0;
        int s = bits >>> 15;
        int e = (bits >>> 10) & 31;
        int m = bits & FP16_SIGNIFICAND_MASK;
        if (e == 31) {
            if (m == 0) {
                if (s != 0) {
                    o.append('-');
                }
                o.append("Infinity");
            } else {
                o.append("NaN");
            }
        } else {
            if (s == 1) {
                o.append('-');
            }
            if (e == 0) {
                if (m == 0) {
                    o.append("0x0.0p0");
                } else {
                    o.append("0x0.");
                    String significand = Integer.toString(m, CharsKt.checkRadix(16));
                    Intrinsics.checkNotNullExpressionValue(significand, "toString(this, checkRadix(radix))");
                    o.append(new Regex("0{2,}$").replaceFirst(significand, ""));
                    o.append("p-14");
                }
            } else {
                o.append("0x1.");
                String significand2 = Integer.toString(m, CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(significand2, "toString(this, checkRadix(radix))");
                o.append(new Regex("0{2,}$").replaceFirst(significand2, ""));
                o.append('p');
                o.append(String.valueOf(e - 15));
            }
        }
        String sb = o.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "o.toString()");
        return sb;
    }

    /* compiled from: Float16.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u001f\n\u0002\u0010\n\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0012H\u0002J\u0010\u00104\u001a\u00020\t2\u0006\u00105\u001a\u000202H\u0002R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001b\u0010\u0006R\u000e\u0010\u001c\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001e\u0010\u0006R\u000e\u0010\u001f\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010 \u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b!\u0010\u0006R\u001c\u0010\"\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b#\u0010\u0006R\u001c\u0010$\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b%\u0010\u0006R\u001c\u0010&\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b'\u0010\u0006R\u0019\u0010(\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0007R\u001c\u0010)\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b*\u0010\u0006R\u0019\u0010+\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0007R\u001c\u0010,\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b-\u0010\u0006R\u001c\u0010.\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b/\u0010\u0006R\u000e\u00100\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00066"}, d2 = {"Landroidx/compose/ui/graphics/Float16$Companion;", "", "()V", "Epsilon", "Landroidx/compose/ui/graphics/Float16;", "getEpsilon-slo4al4", "()S", "S", "FP16_COMBINED", "", "FP16_EXPONENT_BIAS", "FP16_EXPONENT_MASK", "FP16_EXPONENT_MAX", "FP16_EXPONENT_SHIFT", "FP16_SIGNIFICAND_MASK", "FP16_SIGN_MASK", "FP16_SIGN_SHIFT", "FP32_DENORMAL_FLOAT", "", "FP32_DENORMAL_MAGIC", "FP32_EXPONENT_BIAS", "FP32_EXPONENT_MASK", "FP32_EXPONENT_SHIFT", "FP32_QNAN_MASK", "FP32_SIGNIFICAND_MASK", "FP32_SIGN_SHIFT", "LowestValue", "getLowestValue-slo4al4", "MaxExponent", "MaxValue", "getMaxValue-slo4al4", "MinExponent", "MinNormal", "getMinNormal-slo4al4", "MinValue", "getMinValue-slo4al4", "NaN", "getNaN-slo4al4", "NegativeInfinity", "getNegativeInfinity-slo4al4", "NegativeOne", "NegativeZero", "getNegativeZero-slo4al4", "One", "PositiveInfinity", "getPositiveInfinity-slo4al4", "PositiveZero", "getPositiveZero-slo4al4", "Size", "floatToHalf", "", "f", "toCompareValue", "value", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getEpsilon-slo4al4, reason: not valid java name */
        public final short m3081getEpsilonslo4al4() {
            return Float16.Epsilon;
        }

        /* renamed from: getLowestValue-slo4al4, reason: not valid java name */
        public final short m3082getLowestValueslo4al4() {
            return Float16.LowestValue;
        }

        /* renamed from: getMaxValue-slo4al4, reason: not valid java name */
        public final short m3083getMaxValueslo4al4() {
            return Float16.MaxValue;
        }

        /* renamed from: getMinNormal-slo4al4, reason: not valid java name */
        public final short m3084getMinNormalslo4al4() {
            return Float16.MinNormal;
        }

        /* renamed from: getMinValue-slo4al4, reason: not valid java name */
        public final short m3085getMinValueslo4al4() {
            return Float16.MinValue;
        }

        /* renamed from: getNaN-slo4al4, reason: not valid java name */
        public final short m3086getNaNslo4al4() {
            return Float16.NaN;
        }

        /* renamed from: getNegativeInfinity-slo4al4, reason: not valid java name */
        public final short m3087getNegativeInfinityslo4al4() {
            return Float16.NegativeInfinity;
        }

        /* renamed from: getNegativeZero-slo4al4, reason: not valid java name */
        public final short m3088getNegativeZeroslo4al4() {
            return Float16.NegativeZero;
        }

        /* renamed from: getPositiveInfinity-slo4al4, reason: not valid java name */
        public final short m3089getPositiveInfinityslo4al4() {
            return Float16.PositiveInfinity;
        }

        /* renamed from: getPositiveZero-slo4al4, reason: not valid java name */
        public final short m3090getPositiveZeroslo4al4() {
            return Float16.PositiveZero;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int toCompareValue(short value) {
            if ((value & ShortCompanionObject.MIN_VALUE) != 0) {
                return 32768 - (value & UShort.MAX_VALUE);
            }
            return value & UShort.MAX_VALUE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final short floatToHalf(float f) {
            int bits = Float.floatToRawIntBits(f);
            int s = bits >>> 31;
            int e = (bits >>> 23) & 255;
            int m = Float16.FP32_SIGNIFICAND_MASK & bits;
            int outE = 0;
            int outM = 0;
            if (e == 255) {
                outE = 31;
                outM = m != 0 ? 512 : 0;
            } else {
                int e2 = (e - 127) + 15;
                if (e2 >= 31) {
                    outE = 49;
                } else if (e2 <= 0) {
                    if (e2 >= -10) {
                        int m2 = (8388608 | m) >> (1 - e2);
                        if ((m2 & 4096) != 0) {
                            m2 += 8192;
                        }
                        outM = m2 >> 13;
                    }
                } else {
                    outE = e2;
                    outM = m >> 13;
                    if ((m & 4096) != 0) {
                        int out = (outE << 10) | outM;
                        return (short) ((s << 15) | (out + 1));
                    }
                }
            }
            int out2 = s << 15;
            return (short) (out2 | (outE << 10) | outM);
        }
    }

    static {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        FP32_DENORMAL_FLOAT = Float.intBitsToFloat(FP32_DENORMAL_MAGIC);
    }
}
