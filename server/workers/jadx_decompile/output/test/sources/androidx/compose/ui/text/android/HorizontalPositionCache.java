package androidx.compose.ui.text.android;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextLayout.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/text/android/HorizontalPositionCache;", "", "layout", "Landroidx/compose/ui/text/android/TextLayout;", "(Landroidx/compose/ui/text/android/TextLayout;)V", "cachedKey", "", "cachedValue", "", "getLayout", "()Landroidx/compose/ui/text/android/TextLayout;", "get", "offset", "upstream", "", "cache", "primary", "getPrimaryDownstream", "getPrimaryUpstream", "getSecondaryDownstream", "getSecondaryUpstream", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
final class HorizontalPositionCache {
    private int cachedKey;
    private float cachedValue;
    private final TextLayout layout;

    public HorizontalPositionCache(TextLayout layout) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        this.layout = layout;
        this.cachedKey = -1;
    }

    public final TextLayout getLayout() {
        return this.layout;
    }

    public final float getPrimaryDownstream(int offset) {
        return get(offset, false, false, true);
    }

    public final float getPrimaryUpstream(int offset) {
        return get(offset, true, true, true);
    }

    public final float getSecondaryDownstream(int offset) {
        return get(offset, false, false, false);
    }

    public final float getSecondaryUpstream(int offset) {
        return get(offset, true, true, false);
    }

    private final float get(int offset, boolean upstream, boolean cache, boolean primary) {
        int lineNo;
        float result;
        int i = 1;
        if (upstream) {
            int lineNo2 = LayoutCompatKt.getLineForOffset(this.layout.getLayout(), offset, upstream);
            int lineStart = this.layout.getLineStart(lineNo2);
            int lineEnd = this.layout.getLineEnd(lineNo2);
            lineNo = (offset == lineStart || offset == lineEnd) ? 1 : 0;
        } else {
            lineNo = 0;
        }
        int i2 = offset * 4;
        if (primary) {
            if (lineNo != 0) {
                i = 0;
            }
        } else {
            i = lineNo != 0 ? 2 : 3;
        }
        int tmpKey = i2 + i;
        if (this.cachedKey == tmpKey) {
            return this.cachedValue;
        }
        if (primary) {
            result = this.layout.getPrimaryHorizontal(offset, upstream);
        } else {
            result = this.layout.getSecondaryHorizontal(offset, upstream);
        }
        if (cache) {
            this.cachedKey = tmpKey;
            this.cachedValue = result;
        }
        return result;
    }
}
