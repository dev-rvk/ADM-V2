package androidx.compose.ui.text;

import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidStringDelegate_androidKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: String.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010\t\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\t\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u0012\u0010\n\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0012\u0010\n\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"stringDelegate", "Landroidx/compose/ui/text/PlatformStringDelegate;", "capitalize", "", "locale", "Landroidx/compose/ui/text/intl/Locale;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "decapitalize", "toLowerCase", "toUpperCase", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class StringKt {
    private static final PlatformStringDelegate stringDelegate = AndroidStringDelegate_androidKt.ActualStringDelegate();

    public static final String toUpperCase(String $this$toUpperCase, Locale locale) {
        Intrinsics.checkNotNullParameter($this$toUpperCase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return stringDelegate.toUpperCase($this$toUpperCase, locale.getPlatformLocale());
    }

    public static final String toLowerCase(String $this$toLowerCase, Locale locale) {
        Intrinsics.checkNotNullParameter($this$toLowerCase, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return stringDelegate.toLowerCase($this$toLowerCase, locale.getPlatformLocale());
    }

    public static final String capitalize(String $this$capitalize, Locale locale) {
        Intrinsics.checkNotNullParameter($this$capitalize, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return stringDelegate.capitalize($this$capitalize, locale.getPlatformLocale());
    }

    public static final String decapitalize(String $this$decapitalize, Locale locale) {
        Intrinsics.checkNotNullParameter($this$decapitalize, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return stringDelegate.decapitalize($this$decapitalize, locale.getPlatformLocale());
    }

    public static final String toUpperCase(String $this$toUpperCase, LocaleList localeList) {
        Intrinsics.checkNotNullParameter($this$toUpperCase, "<this>");
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        return toUpperCase($this$toUpperCase, localeList.isEmpty() ? Locale.INSTANCE.getCurrent() : localeList.get(0));
    }

    public static final String toLowerCase(String $this$toLowerCase, LocaleList localeList) {
        Intrinsics.checkNotNullParameter($this$toLowerCase, "<this>");
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        return toLowerCase($this$toLowerCase, localeList.isEmpty() ? Locale.INSTANCE.getCurrent() : localeList.get(0));
    }

    public static final String capitalize(String $this$capitalize, LocaleList localeList) {
        Intrinsics.checkNotNullParameter($this$capitalize, "<this>");
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        return capitalize($this$capitalize, localeList.isEmpty() ? Locale.INSTANCE.getCurrent() : localeList.get(0));
    }

    public static final String decapitalize(String $this$decapitalize, LocaleList localeList) {
        Intrinsics.checkNotNullParameter($this$decapitalize, "<this>");
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        return decapitalize($this$decapitalize, localeList.isEmpty() ? Locale.INSTANCE.getCurrent() : localeList.get(0));
    }
}
