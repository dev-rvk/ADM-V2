package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: ContentAlpha.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0003¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006¨\u0006\u000f"}, d2 = {"Landroidx/compose/material/ContentAlpha;", "", "()V", "disabled", "", "getDisabled", "(Landroidx/compose/runtime/Composer;I)F", "high", "getHigh", "medium", "getMedium", "contentAlpha", "highContrastAlpha", "lowContrastAlpha", "(FFLandroidx/compose/runtime/Composer;I)F", "material_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ContentAlpha {
    public static final int $stable = 0;
    public static final ContentAlpha INSTANCE = new ContentAlpha();

    private ContentAlpha() {
    }

    public final float getHigh(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(629162431);
        ComposerKt.sourceInformation($composer, "C34@1107L146:ContentAlpha.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(629162431, $changed, -1, "androidx.compose.material.ContentAlpha.<get-high> (ContentAlpha.kt:34)");
        }
        float contentAlpha = contentAlpha(1.0f, 0.87f, $composer, (($changed << 6) & 896) | 54);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return contentAlpha;
    }

    public final float getMedium(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(1999054879);
        ComposerKt.sourceInformation($composer, "C45@1458L150:ContentAlpha.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1999054879, $changed, -1, "androidx.compose.material.ContentAlpha.<get-medium> (ContentAlpha.kt:45)");
        }
        float contentAlpha = contentAlpha(0.74f, 0.6f, $composer, (($changed << 6) & 896) | 54);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return contentAlpha;
    }

    public final float getDisabled(Composer $composer, int $changed) {
        $composer.startReplaceableGroup(621183615);
        ComposerKt.sourceInformation($composer, "C56@1805L154:ContentAlpha.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(621183615, $changed, -1, "androidx.compose.material.ContentAlpha.<get-disabled> (ContentAlpha.kt:56)");
        }
        float contentAlpha = contentAlpha(0.38f, 0.38f, $composer, (($changed << 6) & 896) | 54);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return contentAlpha;
    }

    private final float contentAlpha(float highContrastAlpha, float lowContrastAlpha, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(-1528360391);
        ComposerKt.sourceInformation($composer, "C(contentAlpha)76@2623L7,77@2670L6:ContentAlpha.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1528360391, $changed, -1, "androidx.compose.material.ContentAlpha.contentAlpha (ContentAlpha.kt:70)");
        }
        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd($composer);
        long contentColor = ((Color) consume).m2959unboximpl();
        boolean lightTheme = MaterialTheme.INSTANCE.getColors($composer, 6).isLight();
        float f = (!lightTheme ? ((double) ColorKt.m3001luminance8_81llA(contentColor)) < 0.5d : ((double) ColorKt.m3001luminance8_81llA(contentColor)) > 0.5d) ? lowContrastAlpha : highContrastAlpha;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return f;
    }
}
