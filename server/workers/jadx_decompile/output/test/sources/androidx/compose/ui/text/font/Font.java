package androidx.compose.ui.text.font;

import android.content.Context;
import android.os.Build;
import androidx.compose.ui.text.font.FontVariation;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidPreloadedFont.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B,\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0010¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\fH\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/text/font/AndroidFileFont;", "Landroidx/compose/ui/text/font/AndroidPreloadedFont;", "file", "Ljava/io/File;", "weight", "Landroidx/compose/ui/text/font/FontWeight;", "style", "Landroidx/compose/ui/text/font/FontStyle;", "variationSettings", "Landroidx/compose/ui/text/font/FontVariation$Settings;", "(Ljava/io/File;Landroidx/compose/ui/text/font/FontWeight;ILandroidx/compose/ui/text/font/FontVariation$Settings;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "cacheKey", "", "getCacheKey", "()Ljava/lang/String;", "getFile", "()Ljava/io/File;", "doLoad", "Landroid/graphics/Typeface;", "context", "Landroid/content/Context;", "doLoad$ui_text_release", "toString", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* renamed from: androidx.compose.ui.text.font.AndroidFileFont, reason: from toString */
/* loaded from: classes.dex */
public final class Font extends AndroidPreloadedFont {
    private final String cacheKey;
    private final File file;

    public /* synthetic */ Font(File file, FontWeight fontWeight, int i, FontVariation.Settings settings, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, fontWeight, i, settings);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ Font(java.io.File r7, androidx.compose.ui.text.font.FontWeight r8, int r9, androidx.compose.ui.text.font.FontVariation.Settings r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r6 = this;
            r12 = r11 & 2
            if (r12 == 0) goto Lc
            androidx.compose.ui.text.font.FontWeight$Companion r8 = androidx.compose.ui.text.font.FontWeight.INSTANCE
            androidx.compose.ui.text.font.FontWeight r8 = r8.getNormal()
            r2 = r8
            goto Ld
        Lc:
            r2 = r8
        Ld:
            r8 = r11 & 4
            if (r8 == 0) goto L19
            androidx.compose.ui.text.font.FontStyle$Companion r8 = androidx.compose.ui.text.font.FontStyle.INSTANCE
            int r9 = r8.m4826getNormal_LCdwA()
            r3 = r9
            goto L1a
        L19:
            r3 = r9
        L1a:
            r5 = 0
            r0 = r6
            r1 = r7
            r4 = r10
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.Font.<init>(java.io.File, androidx.compose.ui.text.font.FontWeight, int, androidx.compose.ui.text.font.FontVariation$Settings, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final File getFile() {
        return this.file;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private Font(File file, FontWeight weight, int style, FontVariation.Settings variationSettings) {
        super(weight, style, variationSettings, null);
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(weight, "weight");
        Intrinsics.checkNotNullParameter(variationSettings, "variationSettings");
        this.file = file;
        setTypeface$ui_text_release(doLoad$ui_text_release(null));
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    public android.graphics.Typeface doLoad$ui_text_release(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return TypefaceBuilderCompat.INSTANCE.createFromFile(this.file, context, getVariationSettings());
        }
        return android.graphics.Typeface.createFromFile(this.file);
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    public String getCacheKey() {
        return this.cacheKey;
    }

    public String toString() {
        return "Font(file=" + this.file + ", weight=" + getWeight() + ", style=" + ((Object) FontStyle.m4823toStringimpl(getStyle())) + ')';
    }
}
Cannot create font from file descriptor for SDK < 26");
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    public String getCacheKey() {
        return this.cacheKey;
    }

    public String toString() {
        return "Font(fileDescriptor=" + this.fileDescriptor + ", weight=" + getWeight() + ", style=" + ((Object) FontStyle.m4823toStringimpl(getStyle())) + ')';
    }
}
 doLoad$ui_text_release(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return TypefaceBuilderCompat.INSTANCE.createFromAssets(this.assetManager, this.path, context, getVariationSettings());
        }
        return android.graphics.Typeface.createFromAsset(this.assetManager, this.path);
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    public String getCacheKey() {
        return this.cacheKey;
    }

    public String toString() {
        return "Font(assetManager, path=" + this.path + ", weight=" + getWeight() + ", style=" + ((Object) FontStyle.m4823toStringimpl(getStyle())) + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Font) && Intrinsics.areEqual(this.path, ((Font) other).path) && Intrinsics.areEqual(getVariationSettings(), ((Font) other).getVariationSettings());
    }

    public int hashCode() {
        int result = this.path.hashCode();
        return (result * 31) + getVariationSettings().hashCode();
    }
}
