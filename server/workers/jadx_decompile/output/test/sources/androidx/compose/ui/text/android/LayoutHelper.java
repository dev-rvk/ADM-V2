package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.TextUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: LayoutHelper.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\f\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001:\u0001'B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\rJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u001e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001aJ\u0010\u0010\u001e\u001a\u00020\r2\b\b\u0001\u0010\u0015\u001a\u00020\rJ\u001a\u0010\u001f\u001a\u00020\r2\b\b\u0001\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\u001aJ\u0010\u0010 \u001a\u00020\r2\b\b\u0001\u0010\u0015\u001a\u00020\rJ\u000e\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020\u001a2\b\b\u0001\u0010\u0015\u001a\u00020\rJ\u0010\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\rH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Landroidx/compose/ui/text/android/LayoutHelper;", "", "layout", "Landroid/text/Layout;", "(Landroid/text/Layout;)V", "bidiProcessedParagraphs", "", "getLayout", "()Landroid/text/Layout;", "paragraphBidi", "", "Ljava/text/Bidi;", "paragraphCount", "", "getParagraphCount", "()I", "paragraphEnds", "", "tmpBuffer", "", "analyzeBidi", "paragraphIndex", "getDownstreamHorizontal", "", "offset", "primary", "", "getHorizontalPosition", "usePrimaryDirection", "upstream", "getParagraphEnd", "getParagraphForOffset", "getParagraphStart", "isLineEndSpace", "c", "", "isRtlParagraph", "lineEndToVisibleEnd", "lineEnd", "BidiRun", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LayoutHelper {
    private final boolean[] bidiProcessedParagraphs;
    private final Layout layout;
    private final List<Bidi> paragraphBidi;
    private final int paragraphCount;
    private final List<Integer> paragraphEnds;
    private char[] tmpBuffer;

    public LayoutHelper(Layout layout) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        this.layout = layout;
        int paragraphEnd = 0;
        List lineFeeds = new ArrayList();
        do {
            CharSequence text = this.layout.getText();
            Intrinsics.checkNotNullExpressionValue(text, "layout.text");
            int paragraphEnd2 = StringsKt.indexOf$default(text, '\n', paragraphEnd, false, 4, (Object) null);
            if (paragraphEnd2 < 0) {
                paragraphEnd = this.layout.getText().length();
            } else {
                paragraphEnd = paragraphEnd2 + 1;
            }
            lineFeeds.add(Integer.valueOf(paragraphEnd));
        } while (paragraphEnd < this.layout.getText().length());
        this.paragraphEnds = lineFeeds;
        int size = this.paragraphEnds.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(null);
        }
        this.paragraphBidi = arrayList;
        this.bidiProcessedParagraphs = new boolean[this.paragraphEnds.size()];
        this.paragraphCount = this.paragraphEnds.size();
    }

    public final Layout getLayout() {
        return this.layout;
    }

    public final Bidi analyzeBidi(int paragraphIndex) {
        char[] cArr;
        Bidi bidi;
        int flag;
        if (this.bidiProcessedParagraphs[paragraphIndex]) {
            return this.paragraphBidi.get(paragraphIndex);
        }
        int paragraphStart = paragraphIndex == 0 ? 0 : this.paragraphEnds.get(paragraphIndex - 1).intValue();
        int paragraphEnd = this.paragraphEnds.get(paragraphIndex).intValue();
        int paragraphLength = paragraphEnd - paragraphStart;
        char[] buffer = this.tmpBuffer;
        if (buffer == null || buffer.length < paragraphLength) {
            cArr = new char[paragraphLength];
        } else {
            cArr = buffer;
        }
        char[] buffer2 = cArr;
        TextUtils.getChars(this.layout.getText(), paragraphStart, paragraphEnd, buffer2, 0);
        char[] cArr2 = null;
        if (Bidi.requiresBidi(buffer2, 0, paragraphLength)) {
            if (isRtlParagraph(paragraphIndex)) {
                flag = 1;
            } else {
                flag = 0;
            }
            bidi = new Bidi(buffer2, 0, null, 0, paragraphLength, flag);
            if (bidi.getRunCount() == 1) {
                bidi = null;
            }
        } else {
            bidi = null;
        }
        this.paragraphBidi.set(paragraphIndex, bidi);
        this.bidiProcessedParagraphs[paragraphIndex] = true;
        if (bidi != null) {
            if (buffer2 != this.tmpBuffer) {
                cArr2 = this.tmpBuffer;
            }
        } else {
            cArr2 = buffer2;
        }
        this.tmpBuffer = cArr2;
        return bidi;
    }

    public final int getParagraphCount() {
        return this.paragraphCount;
    }

    public static /* synthetic */ int getParagraphForOffset$default(LayoutHelper layoutHelper, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return layoutHelper.getParagraphForOffset(i, z);
    }

    public final int getParagraphForOffset(int offset, boolean upstream) {
        int it = CollectionsKt.binarySearch$default(this.paragraphEnds, Integer.valueOf(offset), 0, 0, 6, (Object) null);
        int i = it + 1;
        if (it < 0) {
            i = -i;
        }
        int it2 = i;
        if (upstream && it2 > 0 && offset == this.paragraphEnds.get(it2 - 1).intValue()) {
            return it2 - 1;
        }
        return it2;
    }

    public final int getParagraphStart(int paragraphIndex) {
        if (paragraphIndex == 0) {
            return 0;
        }
        return this.paragraphEnds.get(paragraphIndex - 1).intValue();
    }

    public final int getParagraphEnd(int paragraphIndex) {
        return this.paragraphEnds.get(paragraphIndex).intValue();
    }

    public final boolean isRtlParagraph(int paragraphIndex) {
        int lineNumber = this.layout.getLineForOffset(getParagraphStart(paragraphIndex));
        return this.layout.getParagraphDirection(lineNumber) == -1;
    }

    public final float getHorizontalPosition(int offset, boolean usePrimaryDirection, boolean upstream) {
        boolean isStartLeft;
        int lineEndAdjustedOffset;
        boolean isLeftRequested;
        int index;
        boolean z;
        if (!upstream) {
            return getDownstreamHorizontal(offset, usePrimaryDirection);
        }
        int lineNo = LayoutCompatKt.getLineForOffset(this.layout, offset, upstream);
        int lineStart = this.layout.getLineStart(lineNo);
        int lineEnd = this.layout.getLineEnd(lineNo);
        if (offset != lineStart && offset != lineEnd) {
            return getDownstreamHorizontal(offset, usePrimaryDirection);
        }
        if (offset != 0 && offset != this.layout.getText().length()) {
            int paraNo = getParagraphForOffset(offset, upstream);
            boolean isParaRtl = isRtlParagraph(paraNo);
            int lineVisibleEnd = lineEndToVisibleEnd(lineEnd);
            int paragraphStart = getParagraphStart(paraNo);
            int bidiStart = lineStart - paragraphStart;
            int bidiEnd = lineVisibleEnd - paragraphStart;
            Bidi analyzeBidi = analyzeBidi(paraNo);
            Bidi lineBidi = analyzeBidi != null ? analyzeBidi.createLineBidi(bidiStart, bidiEnd) : null;
            if (lineBidi != null && lineBidi.getRunCount() != 1) {
                int runCount = lineBidi.getRunCount();
                BidiRun[] runs = new BidiRun[runCount];
                int i = 0;
                while (i < runCount) {
                    int lineEnd2 = lineEnd;
                    int paraNo2 = paraNo;
                    int paragraphStart2 = paragraphStart;
                    int bidiStart2 = bidiStart;
                    runs[i] = new BidiRun(lineStart + lineBidi.getRunStart(i), lineStart + lineBidi.getRunLimit(i), lineBidi.getRunLevel(i) % 2 == 1);
                    i++;
                    bidiStart = bidiStart2;
                    lineEnd = lineEnd2;
                    paraNo = paraNo2;
                    paragraphStart = paragraphStart2;
                }
                int runCount2 = lineBidi.getRunCount();
                byte[] levels = new byte[runCount2];
                for (int i2 = 0; i2 < runCount2; i2++) {
                    levels[i2] = (byte) lineBidi.getRunLevel(i2);
                }
                Bidi.reorderVisually(levels, 0, runs, 0, runs.length);
                if (offset != lineStart) {
                    if (offset > lineVisibleEnd) {
                        lineEndAdjustedOffset = lineEndToVisibleEnd(offset);
                    } else {
                        lineEndAdjustedOffset = offset;
                    }
                    int index$iv = 0;
                    int length = runs.length;
                    while (true) {
                        if (index$iv < length) {
                            BidiRun it = runs[index$iv];
                            if (it.getEnd() == lineEndAdjustedOffset) {
                                break;
                            }
                            index$iv++;
                        } else {
                            index$iv = -1;
                            break;
                        }
                    }
                    int index2 = index$iv;
                    BidiRun run = runs[index2];
                    if (usePrimaryDirection || isParaRtl == run.isRtl()) {
                        isLeftRequested = isParaRtl;
                    } else {
                        isLeftRequested = !isParaRtl;
                    }
                    if (index2 == 0 && isLeftRequested) {
                        return this.layout.getLineLeft(lineNo);
                    }
                    if (index2 == ArraysKt.getLastIndex(runs) && !isLeftRequested) {
                        return this.layout.getLineRight(lineNo);
                    }
                    if (isLeftRequested) {
                        return this.layout.getPrimaryHorizontal(runs[index2 - 1].getEnd());
                    }
                    return this.layout.getPrimaryHorizontal(runs[index2 + 1].getEnd());
                }
                int index$iv2 = 0;
                int length2 = runs.length;
                while (true) {
                    if (index$iv2 < length2) {
                        BidiRun it2 = runs[index$iv2];
                        if (!(it2.getStart() == offset)) {
                            index$iv2++;
                        } else {
                            index = index$iv2;
                            break;
                        }
                    } else {
                        index = -1;
                        break;
                    }
                }
                BidiRun run2 = runs[index];
                if (usePrimaryDirection || isParaRtl == run2.isRtl()) {
                    z = !isParaRtl;
                } else {
                    z = isParaRtl;
                }
                boolean isLeftRequested2 = z;
                if (index == 0 && isLeftRequested2) {
                    return this.layout.getLineLeft(lineNo);
                }
                if (index == ArraysKt.getLastIndex(runs) && !isLeftRequested2) {
                    return this.layout.getLineRight(lineNo);
                }
                if (isLeftRequested2) {
                    return this.layout.getPrimaryHorizontal(runs[index - 1].getStart());
                }
                return this.layout.getPrimaryHorizontal(runs[index + 1].getStart());
            }
            boolean runDirection = this.layout.isRtlCharAt(lineStart);
            if (usePrimaryDirection || isParaRtl == runDirection) {
                isStartLeft = !isParaRtl;
            } else {
                isStartLeft = isParaRtl;
            }
            boolean isOffsetLeft = offset == lineStart ? isStartLeft : !isStartLeft;
            Layout layout = this.layout;
            return isOffsetLeft ? layout.getLineLeft(lineNo) : layout.getLineRight(lineNo);
        }
        return getDownstreamHorizontal(offset, usePrimaryDirection);
    }

    private final float getDownstreamHorizontal(int offset, boolean primary) {
        if (primary) {
            return this.layout.getPrimaryHorizontal(offset);
        }
        return this.layout.getSecondaryHorizontal(offset);
    }

    /* compiled from: LayoutHelper.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;", "", "start", "", "end", "isRtl", "", "(IIZ)V", "getEnd", "()I", "()Z", "getStart", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    private static final /* data */ class BidiRun {
        private final int end;
        private final boolean isRtl;
        private final int start;

        public static /* synthetic */ BidiRun copy$default(BidiRun bidiRun, int i, int i2, boolean z, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = bidiRun.start;
            }
            if ((i3 & 2) != 0) {
                i2 = bidiRun.end;
            }
            if ((i3 & 4) != 0) {
                z = bidiRun.isRtl;
            }
            return bidiRun.copy(i, i2, z);
        }

        /* renamed from: component1, reason: from getter */
        public final int getStart() {
            return this.start;
        }

        /* renamed from: component2, reason: from getter */
        public final int getEnd() {
            return this.end;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsRtl() {
            return this.isRtl;
        }

        public final BidiRun copy(int start, int end, boolean isRtl) {
            return new BidiRun(start, end, isRtl);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BidiRun)) {
                return false;
            }
            BidiRun bidiRun = (BidiRun) other;
            return this.start == bidiRun.start && this.end == bidiRun.end && this.isRtl == bidiRun.isRtl;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((Integer.hashCode(this.start) * 31) + Integer.hashCode(this.end)) * 31;
            boolean z = this.isRtl;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            return hashCode + i;
        }

        public String toString() {
            return "BidiRun(start=" + this.start + ", end=" + this.end + ", isRtl=" + this.isRtl + ')';
        }

        public BidiRun(int start, int end, boolean isRtl) {
            this.start = start;
            this.end = end;
            this.isRtl = isRtl;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getStart() {
            return this.start;
        }

        public final boolean isRtl() {
            return this.isRtl;
        }
    }

    private final int lineEndToVisibleEnd(int lineEnd) {
        int visibleEnd = lineEnd;
        while (visibleEnd > 0 && isLineEndSpace(this.layout.getText().charAt(visibleEnd - 1))) {
            visibleEnd--;
        }
        return visibleEnd;
    }

    public final boolean isLineEndSpace(char c) {
        if (c == ' ' || c == '\n' || c == 5760) {
            return true;
        }
        return ((8192 <= c && c < 8203) && c != 8199) || c == 8287 || c == 12288;
    }
}
