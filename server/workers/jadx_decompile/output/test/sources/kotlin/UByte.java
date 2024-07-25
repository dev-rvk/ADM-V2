package kotlin;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;

/* compiled from: UByte.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 v2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001vB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u000fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0012J\u001b\u0010\u001b\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u000fJ\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0012J\u001b\u0010&\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b)\u0010\u001fJ\u001b\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0018J\u0010\u0010+\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b,\u0010-J\u0016\u0010.\u001a\u00020\u0000H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010\u0005J\u0016\u00100\u001a\u00020\u0000H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0005J\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u000fJ\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u0012J\u001b\u00102\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\b5\u0010\u001fJ\u001b\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b6\u0010\u0018J\u001b\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b8\u0010\u000bJ\u001b\u00107\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\bø\u0001\u0000¢\u0006\u0004\b9\u0010\u0012J\u001b\u00107\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\b:\u0010\u001fJ\u001b\u00107\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\b;\u0010<J\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b>\u0010\u000bJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u000fJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u0012J\u001b\u0010?\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u001fJ\u001b\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bC\u0010\u0018J\u001b\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bF\u0010GJ\u001b\u0010H\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bI\u0010GJ\u001b\u0010J\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bK\u0010\u000fJ\u001b\u0010J\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\bL\u0010\u0012J\u001b\u0010J\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\bM\u0010\u001fJ\u001b\u0010J\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bN\u0010\u0018J\u001b\u0010O\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bP\u0010\u000fJ\u001b\u0010O\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\nø\u0001\u0000¢\u0006\u0004\bQ\u0010\u0012J\u001b\u0010O\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\nø\u0001\u0000¢\u0006\u0004\bR\u0010\u001fJ\u001b\u0010O\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bS\u0010\u0018J\u0010\u0010T\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bU\u0010\u0005J\u0010\u0010V\u001a\u00020WH\u0087\b¢\u0006\u0004\bX\u0010YJ\u0010\u0010Z\u001a\u00020[H\u0087\b¢\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020\rH\u0087\b¢\u0006\u0004\b_\u0010-J\u0010\u0010`\u001a\u00020aH\u0087\b¢\u0006\u0004\bb\u0010cJ\u0010\u0010d\u001a\u00020eH\u0087\b¢\u0006\u0004\bf\u0010gJ\u000f\u0010h\u001a\u00020iH\u0016¢\u0006\u0004\bj\u0010kJ\u0016\u0010l\u001a\u00020\u0000H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bm\u0010\u0005J\u0016\u0010n\u001a\u00020\u0010H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bo\u0010-J\u0016\u0010p\u001a\u00020\u0013H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bq\u0010cJ\u0016\u0010r\u001a\u00020\u0016H\u0087\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bs\u0010gJ\u001b\u0010t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bu\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006w"}, d2 = {"Lkotlin/UByte;", "", "data", "", "constructor-impl", "(B)B", "getData$annotations", "()V", "and", "other", "and-7apg3OU", "(BB)B", "compareTo", "", "compareTo-7apg3OU", "(BB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "dec", "dec-w2LRezQ", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(BJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(BLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(B)I", "inc", "inc-w2LRezQ", "inv", "inv-w2LRezQ", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(BS)S", "or", "or-7apg3OU", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-7apg3OU", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "toByte-impl", "toDouble", "", "toDouble-impl", "(B)D", "toFloat", "", "toFloat-impl", "(B)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(B)J", "toShort", "", "toShort-impl", "(B)S", "toString", "", "toString-impl", "(B)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-7apg3OU", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
/* loaded from: classes5.dex */
public final class UByte implements Comparable<UByte> {
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    private final byte data;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UByte m5627boximpl(byte b) {
        return new UByte(b);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static byte m5633constructorimpl(byte b) {
        return b;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m5639equalsimpl(byte b, Object obj) {
        return (obj instanceof UByte) && b == ((UByte) obj).getData();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m5640equalsimpl0(byte b, byte b2) {
        return b == b2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m5645hashCodeimpl(byte b) {
        return Byte.hashCode(b);
    }

    public boolean equals(Object obj) {
        return m5639equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m5645hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ byte getData() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UByte uByte) {
        return Intrinsics.compare(getData() & MAX_VALUE, uByte.getData() & MAX_VALUE);
    }

    private /* synthetic */ UByte(byte data) {
        this.data = data;
    }

    /* renamed from: compareTo-7apg3OU, reason: not valid java name */
    private int m5628compareTo7apg3OU(byte other) {
        return Intrinsics.compare(getData() & MAX_VALUE, other & MAX_VALUE);
    }

    /* renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static int m5629compareTo7apg3OU(byte arg0, byte other) {
        return Intrinsics.compare(arg0 & MAX_VALUE, other & MAX_VALUE);
    }

    /* renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m5632compareToxj2QHRw(byte arg0, short other) {
        return Intrinsics.compare(arg0 & MAX_VALUE, 65535 & other);
    }

    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m5631compareToWZ4Q5Ns(byte arg0, int other) {
        int compare;
        compare = Integer.compare(UInt.m5710constructorimpl(arg0 & MAX_VALUE) ^ Integer.MIN_VALUE, other ^ Integer.MIN_VALUE);
        return compare;
    }

    /* renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m5630compareToVKZWuLQ(byte arg0, long other) {
        int compare;
        compare = Long.compare(ULong.m5789constructorimpl(arg0 & 255) ^ Long.MIN_VALUE, other ^ Long.MIN_VALUE);
        return compare;
    }

    /* renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m5657plus7apg3OU(byte arg0, byte other) {
        return UInt.m5710constructorimpl(UInt.m5710constructorimpl(arg0 & MAX_VALUE) + UInt.m5710constructorimpl(other & MAX_VALUE));
    }

    /* renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m5660plusxj2QHRw(byte arg0, short other) {
        return UInt.m5710constructorimpl(UInt.m5710constructorimpl(arg0 & MAX_VALUE) + UInt.m5710constructorimpl(65535 & other));
    }

    /* renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m5659plusWZ4Q5Ns(byte arg0, int other) {
        return UInt.m5710constructorimpl(UInt.m5710constructorimpl(arg0 & MAX_VALUE) + other);
    }

    /* renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m5658plusVKZWuLQ(byte arg0, long other) {
        return ULong.m5789constructorimpl(ULong.m5789constructorimpl(arg0 & 255) + other);
    }

    /* renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m5648minus7apg3OU(byte arg0, byte other) {
        return UInt.m5710constructorimpl(UInt.m5710constructorimpl(arg0 & MAX_VALUE) - UInt.m5710constructorimpl(other & MAX_VALUE));
    }

    /* renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m5651minusxj2QHRw(byte arg0, short other) {
        return UInt.m5710constructorimpl(UInt.m5710constructorimpl(arg0 & MAX_VALUE) - UInt.m5710constructorimpl(65535 & other));
    }

    /* renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m5650minusWZ4Q5Ns(byte arg0, int other) {
        return UInt.m5710constructorimpl(UInt.m5710constructorimpl(arg0 & MAX_VALUE) - other);
    }

    /* renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m5649minusVKZWuLQ(byte arg0, long other) {
        return ULong.m5789constructorimpl(ULong.m5789constructorimpl(arg0 & 255) - other);
    }

    /* renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m5667times7apg3OU(byte arg0, byte other) {
        return UInt.m5710constructorimpl(UInt.m5710constructorimpl(arg0 & MAX_VALUE) * UInt.m5710constructorimpl(other & MAX_VALUE));
    }

    /* renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m5670timesxj2QHRw(byte arg0, short other) {
        return UInt.m5710constructorimpl(UInt.m5710constructorimpl(arg0 & MAX_VALUE) * UInt.m5710constructorimpl(65535 & other));
    }

    /* renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m5669timesWZ4Q5Ns(byte arg0, int other) {
        return UInt.m5710constructorimpl(UInt.m5710constructorimpl(arg0 & MAX_VALUE) * other);
    }

    /* renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m5668timesVKZWuLQ(byte arg0, long other) {
        return ULong.m5789constructorimpl(ULong.m5789constructorimpl(arg0 & 255) * other);
    }

    /* renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m5635div7apg3OU(byte arg0, byte other) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m5710constructorimpl(arg0 & MAX_VALUE), UInt.m5710constructorimpl(other & MAX_VALUE));
    }

    /* renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m5638divxj2QHRw(byte arg0, short other) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m5710constructorimpl(arg0 & MAX_VALUE), UInt.m5710constructorimpl(65535 & other));
    }

    /* renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m5637divWZ4Q5Ns(byte arg0, int other) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m5710constructorimpl(arg0 & MAX_VALUE), other);
    }

    /* renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m5636divVKZWuLQ(byte arg0, long other) {
        return UByte$$ExternalSyntheticBackport3.m(ULong.m5789constructorimpl(arg0 & 255), other);
    }

    /* renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m5663rem7apg3OU(byte arg0, byte other) {
        return UByte$$ExternalSyntheticBackport1.m(UInt.m5710constructorimpl(arg0 & MAX_VALUE), UInt.m5710constructorimpl(other & MAX_VALUE));
    }

    /* renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m5666remxj2QHRw(byte arg0, short other) {
        return UByte$$ExternalSyntheticBackport1.m(UInt.m5710constructorimpl(arg0 & MAX_VALUE), UInt.m5710constructorimpl(65535 & other));
    }

    /* renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m5665remWZ4Q5Ns(byte arg0, int other) {
        return UByte$$ExternalSyntheticBackport1.m(UInt.m5710constructorimpl(arg0 & MAX_VALUE), other);
    }

    /* renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m5664remVKZWuLQ(byte arg0, long other) {
        return UByte$$ExternalSyntheticBackport2.m(ULong.m5789constructorimpl(arg0 & 255), other);
    }

    /* renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m5641floorDiv7apg3OU(byte arg0, byte other) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m5710constructorimpl(arg0 & MAX_VALUE), UInt.m5710constructorimpl(other & MAX_VALUE));
    }

    /* renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m5644floorDivxj2QHRw(byte arg0, short other) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m5710constructorimpl(arg0 & MAX_VALUE), UInt.m5710constructorimpl(65535 & other));
    }

    /* renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m5643floorDivWZ4Q5Ns(byte arg0, int other) {
        return UByte$$ExternalSyntheticBackport0.m(UInt.m5710constructorimpl(arg0 & MAX_VALUE), other);
    }

    /* renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m5642floorDivVKZWuLQ(byte arg0, long other) {
        return UByte$$ExternalSyntheticBackport3.m(ULong.m5789constructorimpl(arg0 & 255), other);
    }

    /* renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m5652mod7apg3OU(byte arg0, byte other) {
        return m5633constructorimpl((byte) UByte$$ExternalSyntheticBackport1.m(UInt.m5710constructorimpl(arg0 & MAX_VALUE), UInt.m5710constructorimpl(other & MAX_VALUE)));
    }

    /* renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m5655modxj2QHRw(byte arg0, short other) {
        return UShort.m5896constructorimpl((short) UByte$$ExternalSyntheticBackport1.m(UInt.m5710constructorimpl(arg0 & MAX_VALUE), UInt.m5710constructorimpl(65535 & other)));
    }

    /* renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m5654modWZ4Q5Ns(byte arg0, int other) {
        return UByte$$ExternalSyntheticBackport1.m(UInt.m5710constructorimpl(arg0 & MAX_VALUE), other);
    }

    /* renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m5653modVKZWuLQ(byte arg0, long other) {
        return UByte$$ExternalSyntheticBackport2.m(ULong.m5789constructorimpl(arg0 & 255), other);
    }

    /* renamed from: inc-w2LRezQ, reason: not valid java name */
    private static final byte m5646incw2LRezQ(byte arg0) {
        return m5633constructorimpl((byte) (arg0 + 1));
    }

    /* renamed from: dec-w2LRezQ, reason: not valid java name */
    private static final byte m5634decw2LRezQ(byte arg0) {
        return m5633constructorimpl((byte) (arg0 - 1));
    }

    /* renamed from: rangeTo-7apg3OU, reason: not valid java name */
    private static final UIntRange m5661rangeTo7apg3OU(byte arg0, byte other) {
        return new UIntRange(UInt.m5710constructorimpl(arg0 & MAX_VALUE), UInt.m5710constructorimpl(other & MAX_VALUE), null);
    }

    /* renamed from: rangeUntil-7apg3OU, reason: not valid java name */
    private static final UIntRange m5662rangeUntil7apg3OU(byte arg0, byte other) {
        return URangesKt.m6882untilJ1ME1BU(UInt.m5710constructorimpl(arg0 & MAX_VALUE), UInt.m5710constructorimpl(other & MAX_VALUE));
    }

    /* renamed from: and-7apg3OU, reason: not valid java name */
    private static final byte m5626and7apg3OU(byte arg0, byte other) {
        return m5633constructorimpl((byte) (arg0 & other));
    }

    /* renamed from: or-7apg3OU, reason: not valid java name */
    private static final byte m5656or7apg3OU(byte arg0, byte other) {
        return m5633constructorimpl((byte) (arg0 | other));
    }

    /* renamed from: xor-7apg3OU, reason: not valid java name */
    private static final byte m5682xor7apg3OU(byte arg0, byte other) {
        return m5633constructorimpl((byte) (arg0 ^ other));
    }

    /* renamed from: inv-w2LRezQ, reason: not valid java name */
    private static final byte m5647invw2LRezQ(byte arg0) {
        return m5633constructorimpl((byte) (~arg0));
    }

    /* renamed from: toByte-impl, reason: not valid java name */
    private static final byte m5671toByteimpl(byte arg0) {
        return arg0;
    }

    /* renamed from: toShort-impl, reason: not valid java name */
    private static final short m5676toShortimpl(byte arg0) {
        return (short) (arg0 & 255);
    }

    /* renamed from: toInt-impl, reason: not valid java name */
    private static final int m5674toIntimpl(byte arg0) {
        return arg0 & MAX_VALUE;
    }

    /* renamed from: toLong-impl, reason: not valid java name */
    private static final long m5675toLongimpl(byte arg0) {
        return arg0 & 255;
    }

    /* renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m5678toUBytew2LRezQ(byte arg0) {
        return arg0;
    }

    /* renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m5681toUShortMh2AYeg(byte arg0) {
        return UShort.m5896constructorimpl((short) (arg0 & 255));
    }

    /* renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m5679toUIntpVg5ArA(byte arg0) {
        return UInt.m5710constructorimpl(arg0 & MAX_VALUE);
    }

    /* renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m5680toULongsVKNKU(byte arg0) {
        return ULong.m5789constructorimpl(arg0 & 255);
    }

    /* renamed from: toFloat-impl, reason: not valid java name */
    private static final float m5673toFloatimpl(byte arg0) {
        return arg0 & MAX_VALUE;
    }

    /* renamed from: toDouble-impl, reason: not valid java name */
    private static final double m5672toDoubleimpl(byte arg0) {
        return arg0 & MAX_VALUE;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m5677toStringimpl(byte arg0) {
        return String.valueOf(arg0 & MAX_VALUE);
    }

    public String toString() {
        return m5677toStringimpl(this.data);
    }
}