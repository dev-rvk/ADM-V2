package androidx.compose.ui.res;

import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringResources.android.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\u001a\u001f\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0005\u001a3\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0001\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000b\u001a\u0017\u0010\f\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\r\u001a+\u0010\f\u001a\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\bH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"pluralStringResource", "", "id", "", "count", "(IILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "formatArgs", "", "", "(II[Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "stringArrayResource", "(ILandroidx/compose/runtime/Composer;I)[Ljava/lang/String;", "stringResource", "(ILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "(I[Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class StringResources_androidKt {
    public static final String stringResource(int id, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1223887937, "C(stringResource)33@1088L11:StringResources.android.kt#ccshc7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1223887937, $changed, -1, "androidx.compose.ui.res.stringResource (StringResources.android.kt:32)");
        }
        Resources resources = Resources_androidKt.resources($composer, 0);
        String string = resources.getString(id);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(id)");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return string;
    }

    public static final String stringResource(int id, Object[] formatArgs, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        ComposerKt.sourceInformationMarkerStart($composer, 2071230100, "C(stringResource)P(1)47@1452L11:StringResources.android.kt#ccshc7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2071230100, $changed, -1, "androidx.compose.ui.res.stringResource (StringResources.android.kt:46)");
        }
        Resources resources = Resources_androidKt.resources($composer, 0);
        String string = resources.getString(id, Arrays.copyOf(formatArgs, formatArgs.length));
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(id, *formatArgs)");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return string;
    }

    public static final String[] stringArrayResource(int id, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1562162650, "C(stringArrayResource)60@1758L11:StringResources.android.kt#ccshc7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1562162650, $changed, -1, "androidx.compose.ui.res.stringArrayResource (StringResources.android.kt:59)");
        }
        Resources resources = Resources_androidKt.resources($composer, 0);
        String[] stringArray = resources.getStringArray(id);
        Intrinsics.checkNotNullExpressionValue(stringArray, "resources.getStringArray(id)");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return stringArray;
    }

    public static final String pluralStringResource(int id, int count, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 1784741530, "C(pluralStringResource)P(1)74@2102L11:StringResources.android.kt#ccshc7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1784741530, $changed, -1, "androidx.compose.ui.res.pluralStringResource (StringResources.android.kt:73)");
        }
        Resources resources = Resources_androidKt.resources($composer, 0);
        String quantityString = resources.getQuantityString(id, count);
        Intrinsics.checkNotNullExpressionValue(quantityString, "resources.getQuantityString(id, count)");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return quantityString;
    }

    public static final String pluralStringResource(int id, int count, Object[] formatArgs, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        ComposerKt.sourceInformationMarkerStart($composer, 523207213, "C(pluralStringResource)P(2)89@2568L11:StringResources.android.kt#ccshc7");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(523207213, $changed, -1, "androidx.compose.ui.res.pluralStringResource (StringResources.android.kt:88)");
        }
        Resources resources = Resources_androidKt.resources($composer, 0);
        String quantityString = resources.getQuantityString(id, count, Arrays.copyOf(formatArgs, formatArgs.length));
        Intrinsics.checkNotNullExpressionValue(quantityString, "resources.getQuantityStr…g(id, count, *formatArgs)");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return quantityString;
    }
}
