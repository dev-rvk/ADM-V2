package androidx.compose.ui.text.input;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GapBuffer.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0086\u0002J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003J\b\u0010\u0017\u001a\u00020\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0004¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/text/input/PartialGapBuffer;", "", "text", "", "(Ljava/lang/String;)V", "bufEnd", "", "bufStart", "buffer", "Landroidx/compose/ui/text/input/GapBuffer;", "length", "getLength", "()I", "getText", "()Ljava/lang/String;", "setText", "get", "", "index", "replace", "", "start", "end", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class PartialGapBuffer {
    public static final int BUF_SIZE = 255;
    public static final int NOWHERE = -1;
    public static final int SURROUNDING_SIZE = 64;
    private int bufEnd;
    private int bufStart;
    private GapBuffer buffer;
    private String text;
    public static final int $stable = 8;

    public PartialGapBuffer(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
        this.bufStart = -1;
        this.bufEnd = -1;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public final int getLength() {
        GapBuffer buffer = this.buffer;
        return buffer == null ? this.text.length() : (this.text.length() - (this.bufEnd - this.bufStart)) + buffer.length();
    }

    public final void replace(int start, int end, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (!(start <= end)) {
            throw new IllegalArgumentException(("start index must be less than or equal to end index: " + start + " > " + end).toString());
        }
        if (!(start >= 0)) {
            throw new IllegalArgumentException(("start must be non-negative, but was " + start).toString());
        }
        GapBuffer buffer = this.buffer;
        if (buffer == null) {
            char[] charArray = new char[Math.max(255, text.length() + 128)];
            int leftCopyCount = Math.min(start, 64);
            int rightCopyCount = Math.min(this.text.length() - end, 64);
            GapBuffer_jvmKt.toCharArray(this.text, charArray, 0, start - leftCopyCount, start);
            GapBuffer_jvmKt.toCharArray(this.text, charArray, charArray.length - rightCopyCount, end, end + rightCopyCount);
            GapBufferKt.toCharArray(text, charArray, leftCopyCount);
            this.buffer = new GapBuffer(charArray, text.length() + leftCopyCount, charArray.length - rightCopyCount);
            this.bufStart = start - leftCopyCount;
            this.bufEnd = end + rightCopyCount;
            return;
        }
        int bufferStart = start - this.bufStart;
        int bufferEnd = end - this.bufStart;
        if (bufferStart < 0 || bufferEnd > buffer.length()) {
            this.text = toString();
            this.buffer = null;
            this.bufStart = -1;
            this.bufEnd = -1;
            replace(start, end, text);
            return;
        }
        buffer.replace(bufferStart, bufferEnd, text);
    }

    public final char get(int index) {
        GapBuffer buffer = this.buffer;
        if (buffer == null) {
            return this.text.charAt(index);
        }
        if (index < this.bufStart) {
            return this.text.charAt(index);
        }
        int gapBufLength = buffer.length();
        if (index < this.bufStart + gapBufLength) {
            return buffer.get(index - this.bufStart);
        }
        return this.text.charAt(index - ((gapBufLength - this.bufEnd) + this.bufStart));
    }

    public String toString() {
        GapBuffer b = this.buffer;
        if (b == null) {
            return this.text;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) this.text, 0, this.bufStart);
        b.append(sb);
        sb.append((CharSequence) this.text, this.bufEnd, this.text.length());
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }
}
