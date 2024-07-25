package androidx.compose.material3;

import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: TimePicker.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J¡\u0001\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0006H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019\u0082\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001a"}, d2 = {"Landroidx/compose/material3/TimePickerDefaults;", "", "()V", "colors", "Landroidx/compose/material3/TimePickerColors;", "clockDialColor", "Landroidx/compose/ui/graphics/Color;", "clockDialSelectedContentColor", "clockDialUnselectedContentColor", "selectorColor", "containerColor", "periodSelectorBorderColor", "periodSelectorSelectedContainerColor", "periodSelectorUnselectedContainerColor", "periodSelectorSelectedContentColor", "periodSelectorUnselectedContentColor", "timeSelectorSelectedContainerColor", "timeSelectorUnselectedContainerColor", "timeSelectorSelectedContentColor", "timeSelectorUnselectedContentColor", "colors-u3YEpmA", "(JJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TimePickerColors;", "layoutType", "Landroidx/compose/material3/TimePickerLayoutType;", "layoutType-sDNSZnc", "(Landroidx/compose/runtime/Composer;I)I", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TimePickerDefaults {
    public static final int $stable = 0;
    public static final TimePickerDefaults INSTANCE = new TimePickerDefaults();

    private TimePickerDefaults() {
    }

    /* renamed from: colors-u3YEpmA, reason: not valid java name */
    public final TimePickerColors m1884colorsu3YEpmA(long clockDialColor, long clockDialSelectedContentColor, long clockDialUnselectedContentColor, long selectorColor, long containerColor, long periodSelectorBorderColor, long periodSelectorSelectedContainerColor, long periodSelectorUnselectedContainerColor, long periodSelectorSelectedContentColor, long periodSelectorUnselectedContentColor, long timeSelectorSelectedContainerColor, long timeSelectorUnselectedContainerColor, long timeSelectorSelectedContentColor, long timeSelectorUnselectedContentColor, Composer $composer, int $changed, int $changed1, int i) {
        long clockDialSelectedContentColor2;
        long clockDialUnselectedContentColor2;
        long selectorColor2;
        long containerColor2;
        long periodSelectorBorderColor2;
        long periodSelectorSelectedContainerColor2;
        long periodSelectorUnselectedContainerColor2;
        long periodSelectorSelectedContentColor2;
        long periodSelectorUnselectedContentColor2;
        long timeSelectorSelectedContainerColor2;
        long timeSelectorUnselectedContainerColor2;
        long timeSelectorSelectedContentColor2;
        long timeSelectorUnselectedContentColor2;
        $composer.startReplaceableGroup(-646352288);
        ComposerKt.sourceInformation($composer, "C(colors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,8:c#ui.graphics.Color,10:c#ui.graphics.Color,12:c#ui.graphics.Color,11:c#ui.graphics.Color,13:c#ui.graphics.Color)275@13668L9,276@13758L9,277@13852L9,278@13932L9,279@13990L9,280@14071L9,282@14185L9,285@14372L9,287@14488L9,289@14598L9,291@14712L9,293@14820L9,295@14932L9:TimePicker.kt#uh7d8r");
        long clockDialColor2 = (i & 1) != 0 ? ColorSchemeKt.toColor(TimePickerTokens.INSTANCE.getClockDialColor(), $composer, 6) : clockDialColor;
        if ((i & 2) == 0) {
            clockDialSelectedContentColor2 = clockDialSelectedContentColor;
        } else {
            clockDialSelectedContentColor2 = ColorSchemeKt.toColor(TimePickerTokens.INSTANCE.getClockDialSelectedLabelTextColor(), $composer, 6);
        }
        if ((i & 4) == 0) {
            clockDialUnselectedContentColor2 = clockDialUnselectedContentColor;
        } else {
            clockDialUnselectedContentColor2 = ColorSchemeKt.toColor(TimePickerTokens.INSTANCE.getClockDialUnselectedLabelTextColor(), $composer, 6);
        }
        if ((i & 8) == 0) {
            selectorColor2 = selectorColor;
        } else {
            selectorColor2 = ColorSchemeKt.toColor(TimePickerTokens.INSTANCE.getClockDialSelectorHandleContainerColor(), $composer, 6);
        }
        if ((i & 16) == 0) {
            containerColor2 = containerColor;
        } else {
            containerColor2 = ColorSchemeKt.toColor(TimePickerTokens.INSTANCE.getContainerColor(), $composer, 6);
        }
        if ((i & 32) == 0) {
            periodSelectorBorderColor2 = periodSelectorBorderColor;
        } else {
            periodSelectorBorderColor2 = ColorSchemeKt.toColor(TimePickerTokens.INSTANCE.getPeriodSelectorOutlineColor(), $composer, 6);
        }
        if ((i & 64) == 0) {
            periodSelectorSelectedContainerColor2 = periodSelectorSelectedContainerColor;
        } else {
            periodSelectorSelectedContainerColor2 = ColorSchemeKt.toColor(TimePickerTokens.INSTANCE.getPeriodSelectorSelectedContainerColor(), $composer, 6);
        }
        if ((i & 128) == 0) {
            periodSelectorUnselectedContainerColor2 = periodSelectorUnselectedContainerColor;
        } else {
            periodSelectorUnselectedContainerColor2 = Color.INSTANCE.m2984getTransparent0d7_KjU();
        }
        if ((i & 256) == 0) {
            periodSelectorSelectedContentColor2 = periodSelectorSelectedContentColor;
        } else {
            periodSelectorSelectedContentColor2 = ColorSchemeKt.toColor(TimePickerTokens.INSTANCE.getPeriodSelectorSelectedLabelTextColor(), $composer, 6);
        }
        if ((i & 512) == 0) {
            periodSelectorUnselectedContentColor2 = periodSelectorUnselectedContentColor;
        } else {
            periodSelectorUnselectedContentColor2 = ColorSchemeKt.toColor(TimePickerTokens.INSTANCE.getPeriodSelectorUnselectedLabelTextColor(), $composer, 6);
        }
        if ((i & 1024) == 0) {
            timeSelectorSelectedContainerColor2 = timeSelectorSelectedContainerColor;
        } else {
            timeSelectorSelectedContainerColor2 = ColorSchemeKt.toColor(TimePickerTokens.INSTANCE.getTimeSelectorSelectedContainerColor(), $composer, 6);
        }
        if ((i & 2048) == 0) {
            timeSelectorUnselectedContainerColor2 = timeSelectorUnselectedContainerColor;
        } else {
            timeSelectorUnselectedContainerColor2 = ColorSchemeKt.toColor(TimePickerTokens.INSTANCE.getTimeSelectorUnselectedContainerColor(), $composer, 6);
        }
        if ((i & 4096) == 0) {
            timeSelectorSelectedContentColor2 = timeSelectorSelectedContentColor;
        } else {
            timeSelectorSelectedContentColor2 = ColorSchemeKt.toColor(TimePickerTokens.INSTANCE.getTimeSelectorSelectedLabelTextColor(), $composer, 6);
        }
        if ((i & 8192) == 0) {
            timeSelectorUnselectedContentColor2 = timeSelectorUnselectedContentColor;
        } else {
            timeSelectorUnselectedContentColor2 = ColorSchemeKt.toColor(TimePickerTokens.INSTANCE.getTimeSelectorUnselectedLabelTextColor(), $composer, 6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-646352288, $changed, $changed1, "androidx.compose.material3.TimePickerDefaults.colors (TimePicker.kt:274)");
        }
        TimePickerColors timePickerColors = new TimePickerColors(clockDialColor2, selectorColor2, containerColor2, periodSelectorBorderColor2, clockDialSelectedContentColor2, clockDialUnselectedContentColor2, periodSelectorSelectedContainerColor2, periodSelectorUnselectedContainerColor2, periodSelectorSelectedContentColor2, periodSelectorUnselectedContentColor2, timeSelectorSelectedContainerColor2, timeSelectorUnselectedContainerColor2, timeSelectorSelectedContentColor2, timeSelectorUnselectedContentColor2, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return timePickerColors;
    }

    /* renamed from: layoutType-sDNSZnc, reason: not valid java name */
    public final int m1885layoutTypesDNSZnc(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, 517161502, "C(layoutType)316@16146L27:TimePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(517161502, $changed, -1, "androidx.compose.material3.TimePickerDefaults.layoutType (TimePicker.kt:316)");
        }
        int defaultTimePickerLayoutType = TimePicker_androidKt.getDefaultTimePickerLayoutType($composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return defaultTimePickerLayoutType;
    }
}
