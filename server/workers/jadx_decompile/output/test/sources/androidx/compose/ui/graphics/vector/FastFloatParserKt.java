package androidx.compose.ui.graphics.vector;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: FastFloatParser.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u001a\u0019\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0082\b\u001a\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0082\b\u001a\u0019\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\bH\u0082\b\"\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0010"}, d2 = {"isDigit", "", "", "(C)Z", "charAt", "s", "", "index", "", "fullMultiplicationHighBits", "", "x", "y", "parseFourDigits", "str", "offset", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class FastFloatParserKt {
    private static final boolean isDigit(char $this$isDigit) {
        return ((char) ($this$isDigit + 65488)) < '\n';
    }

    private static final char charAt(CharSequence s, int index) {
        if (index < s.length()) {
            return s.charAt(index);
        }
        return (char) 0;
    }

    private static final long fullMultiplicationHighBits(long x, long y) {
        long xLo = x & 4294967295L;
        long xHi = x >>> 32;
        long yLo = y & 4294967295L;
        long yHi = y >>> 32;
        long xTimesYHi = xHi * yHi;
        long xTimesYMid = xLo * yHi;
        long yTimesXMid = xHi * yLo;
        long xTimesYLo = xLo * yLo;
        long carry = yTimesXMid + (xTimesYLo >>> 32) + (4294967295L & xTimesYMid);
        return xTimesYHi + (carry >>> 32) + (xTimesYMid >>> 32);
    }

    private static final int parseFourDigits(CharSequence str, int offset) {
        long v = str.charAt(offset) | (str.charAt(offset + 1) << 16) | (str.charAt(offset + 2) << 32) | (str.charAt(offset + 3) << 48);
        long base = v - 13511005043687472L;
        long predicate = (19703549022044230L + v) | base;
        if (((-35747867511423104L) & predicate) != 0) {
            return -1;
        }
        return (int) ((281475406208040961L * base) >>> 48);
    }
}
