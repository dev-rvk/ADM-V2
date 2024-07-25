package androidx.compose.material3;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ListItem.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0083@\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0014\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003ø\u0001\u0000\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/ListItemType;", "", "lines", "", "constructor-impl", "(I)I", "compareTo", "other", "compareTo-yh95HIg", "(II)I", "equals", "", "", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@JvmInline
/* loaded from: classes.dex */
public final class ListItemType implements Comparable<ListItemType> {
    private final int lines;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int OneLine = m1587constructorimpl(1);
    private static final int TwoLine = m1587constructorimpl(2);
    private static final int ThreeLine = m1587constructorimpl(3);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ListItemType m1585boximpl(int i) {
        return new ListItemType(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m1587constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1588equalsimpl(int i, Object obj) {
        return (obj instanceof ListItemType) && i == ((ListItemType) obj).getLines();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1589equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1590hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1591toStringimpl(int i) {
        return "ListItemType(lines=" + i + ')';
    }

    public boolean equals(Object obj) {
        return m1588equalsimpl(this.lines, obj);
    }

    public int hashCode() {
        return m1590hashCodeimpl(this.lines);
    }

    public String toString() {
        return m1591toStringimpl(this.lines);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getLines() {
        return this.lines;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ListItemType listItemType) {
        return m1592compareToyh95HIg(listItemType.getLines());
    }

    private /* synthetic */ ListItemType(int lines) {
        this.lines = lines;
    }

    /* renamed from: compareTo-yh95HIg, reason: not valid java name */
    public static int m1586compareToyh95HIg(int arg0, int other) {
        return Intrinsics.compare(arg0, other);
    }

    /* renamed from: compareTo-yh95HIg, reason: not valid java name */
    public int m1592compareToyh95HIg(int other) {
        return m1586compareToyh95HIg(this.lines, other);
    }

    /* compiled from: ListItem.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0000ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/ListItemType$Companion;", "", "()V", "OneLine", "Landroidx/compose/material3/ListItemType;", "getOneLine-AlXitO8", "()I", "I", "ThreeLine", "getThreeLine-AlXitO8", "TwoLine", "getTwoLine-AlXitO8", "getListItemType", "hasOverline", "", "hasSupporting", "getListItemType-7AlIA9s$material3_release", "(ZZ)I", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getOneLine-AlXitO8, reason: not valid java name */
        public final int m1595getOneLineAlXitO8() {
            return ListItemType.OneLine;
        }

        /* renamed from: getTwoLine-AlXitO8, reason: not valid java name */
        public final int m1597getTwoLineAlXitO8() {
            return ListItemType.TwoLine;
        }

        /* renamed from: getThreeLine-AlXitO8, reason: not valid java name */
        public final int m1596getThreeLineAlXitO8() {
            return ListItemType.ThreeLine;
        }

        /* renamed from: getListItemType-7AlIA9s$material3_release, reason: not valid java name */
        public final int m1594getListItemType7AlIA9s$material3_release(boolean hasOverline, boolean hasSupporting) {
            if (hasOverline && hasSupporting) {
                return m1596getThreeLineAlXitO8();
            }
            if (hasOverline || hasSupporting) {
                return m1597getTwoLineAlXitO8();
            }
            return m1595getOneLineAlXitO8();
        }
    }
}
