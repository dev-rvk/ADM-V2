package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DateRangePicker.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0081\u0001\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00142\b\b\u0002\u0010\u001a\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010\u001c\u001a9\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0003¢\u0006\u0002\u0010 \u001a9\u0010!\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0003¢\u0006\u0002\u0010\"\u001ad\u0010#\u001a\u00020\n2!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0003¢\u0006\u0002\u0010*\u001a.\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010\u000b\u001a\u00020)2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0002\u001aM\u00103\u001a\u00020\f2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020:H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a\u0018\u0010=\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u0013H\u0002\u001a)\u0010>\u001a\u00020\n*\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010E\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0006\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\b\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006F"}, d2 = {"CalendarMonthSubheadPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getCalendarMonthSubheadPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "DateRangePickerHeadlinePadding", "DateRangePickerTitlePadding", "HeaderHeightOffset", "Landroidx/compose/ui/unit/Dp;", "F", "DateRangePicker", "", "state", "Landroidx/compose/material3/DateRangePickerState;", "modifier", "Landroidx/compose/ui/Modifier;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "dateValidator", "Lkotlin/Function1;", "", "", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "headline", "showModeToggle", "colors", "Landroidx/compose/material3/DatePickerColors;", "(Landroidx/compose/material3/DateRangePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "DateRangePickerContent", "stateData", "Landroidx/compose/material3/StateData;", "(Landroidx/compose/material3/StateData;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "SwitchableDateEntryContent", "(Landroidx/compose/material3/DateRangePickerState;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "VerticalMonthsList", "onDateSelected", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "dateInMillis", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/StateData;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "customScrollActions", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "scrollUpLabel", "", "scrollDownLabel", "rememberDateRangePickerState", "initialSelectedStartDateMillis", "initialSelectedEndDateMillis", "initialDisplayedMonthMillis", "yearRange", "Lkotlin/ranges/IntRange;", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "rememberDateRangePickerState-pMw4iz8", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DateRangePickerState;", "updateDateSelection", "drawRangeBackground", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "selectedRangeInfo", "Landroidx/compose/material3/SelectedRangeInfo;", "color", "Landroidx/compose/ui/graphics/Color;", "drawRangeBackground-mxwnekA", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;Landroidx/compose/material3/SelectedRangeInfo;J)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DateRangePickerKt {
    private static final PaddingValues CalendarMonthSubheadPadding = PaddingKt.m481PaddingValuesa9UjIt4$default(Dp.m5218constructorimpl(24), Dp.m5218constructorimpl(20), 0.0f, Dp.m5218constructorimpl(8), 4, null);
    private static final PaddingValues DateRangePickerTitlePadding = PaddingKt.m481PaddingValuesa9UjIt4$default(Dp.m5218constructorimpl(64), 0.0f, Dp.m5218constructorimpl(12), 0.0f, 10, null);
    private static final PaddingValues DateRangePickerHeadlinePadding = PaddingKt.m481PaddingValuesa9UjIt4$default(Dp.m5218constructorimpl(64), 0.0f, Dp.m5218constructorimpl(12), Dp.m5218constructorimpl(12), 2, null);
    private static final float HeaderHeightOffset = Dp.m5218constructorimpl(60);

    public static final void DateRangePicker(final DateRangePickerState state, Modifier modifier, DatePickerFormatter dateFormatter, Function1<? super Long, Boolean> function1, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, boolean showModeToggle, DatePickerColors colors, Composer $composer, final int $changed, final int i) {
        final DatePickerFormatter dateFormatter2;
        Function1 dateValidator;
        Function2 function23;
        Function2 function24;
        Modifier modifier2;
        boolean z;
        Function2 title;
        Function2 headline;
        boolean showModeToggle2;
        DatePickerColors colors2;
        Object value$iv$iv;
        Function2 title2;
        Function2 headline2;
        boolean showModeToggle3;
        DatePickerFormatter dateFormatter3;
        DatePickerColors colors3;
        Function1 dateValidator2;
        int i2;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer $composer2 = $composer.startRestartGroup(-1835392055);
        ComposerKt.sourceInformation($composer2, "C(DateRangePicker)P(6,4,1,2,7,3,5)87@4128L34,103@4743L8,124@5421L10,105@4760L1103:DateRangePicker.kt#uh7d8r");
        final int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            dateFormatter2 = dateFormatter;
        } else if (($changed & 896) == 0) {
            dateFormatter2 = dateFormatter;
            $dirty |= $composer2.changed(dateFormatter2) ? 256 : 128;
        } else {
            dateFormatter2 = dateFormatter;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            dateValidator = function1;
        } else if (($changed & 7168) == 0) {
            dateValidator = function1;
            $dirty |= $composer2.changedInstance(dateValidator) ? 2048 : 1024;
        } else {
            dateValidator = function1;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty |= 24576;
            function23 = function2;
        } else if (($changed & 57344) == 0) {
            function23 = function2;
            $dirty |= $composer2.changedInstance(function23) ? 16384 : 8192;
        } else {
            function23 = function2;
        }
        int i7 = i & 32;
        if (i7 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function24 = function22;
        } else if ((458752 & $changed) == 0) {
            function24 = function22;
            $dirty |= $composer2.changedInstance(function24) ? 131072 : 65536;
        } else {
            function24 = function22;
        }
        int i8 = i & 64;
        if (i8 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer2.changed(showModeToggle) ? 1048576 : 524288;
        }
        if (($changed & 29360128) == 0) {
            if ((i & 128) == 0 && $composer2.changed(colors)) {
                i2 = 8388608;
                $dirty |= i2;
            }
            i2 = 4194304;
            $dirty |= i2;
        }
        if (($dirty & 23967451) == 4793490 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            showModeToggle3 = showModeToggle;
            colors3 = colors;
            dateValidator2 = dateValidator;
            headline2 = function24;
            title2 = function23;
            dateFormatter3 = dateFormatter2;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) == 0 || $composer2.getDefaultsInvalid()) {
                Modifier.Companion modifier3 = i3 != 0 ? Modifier.INSTANCE : modifier;
                if (i4 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "CC(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer2.rememberedValue();
                    modifier2 = modifier3;
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = new DatePickerFormatter(null, null, null, 7, null);
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    dateFormatter2 = (DatePickerFormatter) value$iv$iv;
                } else {
                    modifier2 = modifier3;
                }
                if (i5 != 0) {
                    dateValidator = new Function1<Long, Boolean>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$2
                        public final Boolean invoke(long it) {
                            return true;
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
                            return invoke(l.longValue());
                        }
                    };
                }
                if (i6 != 0) {
                    z = true;
                    title = ComposableLambdaKt.composableLambda($composer2, 492752701, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer3, int $changed2) {
                            PaddingValues paddingValues;
                            ComposerKt.sourceInformation($composer3, "C90@4286L127:DateRangePicker.kt#uh7d8r");
                            if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(492752701, $changed2, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:89)");
                                }
                                DateRangePickerDefaults dateRangePickerDefaults = DateRangePickerDefaults.INSTANCE;
                                DateRangePickerState dateRangePickerState = DateRangePickerState.this;
                                Modifier.Companion companion = Modifier.INSTANCE;
                                paddingValues = DateRangePickerKt.DateRangePickerTitlePadding;
                                dateRangePickerDefaults.DateRangePickerTitle(dateRangePickerState, PaddingKt.padding(companion, paddingValues), $composer3, ($dirty & 14) | 432, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer3.skipToGroupEnd();
                        }
                    });
                } else {
                    z = true;
                    title = function23;
                }
                headline = i7 != 0 ? ComposableLambdaKt.composableLambda($composer2, -204181785, z, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$4
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer $composer3, int $changed2) {
                        PaddingValues paddingValues;
                        ComposerKt.sourceInformation($composer3, "C96@4497L152:DateRangePicker.kt#uh7d8r");
                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-204181785, $changed2, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:95)");
                            }
                            DateRangePickerDefaults dateRangePickerDefaults = DateRangePickerDefaults.INSTANCE;
                            DateRangePickerState dateRangePickerState = DateRangePickerState.this;
                            DatePickerFormatter datePickerFormatter = dateFormatter2;
                            Modifier.Companion companion = Modifier.INSTANCE;
                            paddingValues = DateRangePickerKt.DateRangePickerHeadlinePadding;
                            dateRangePickerDefaults.DateRangePickerHeadline(dateRangePickerState, datePickerFormatter, PaddingKt.padding(companion, paddingValues), $composer3, ($dirty & 14) | 3456 | (($dirty >> 3) & 112), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }) : function22;
                showModeToggle2 = i8 != 0 ? true : showModeToggle;
                if ((i & 128) != 0) {
                    colors2 = DatePickerDefaults.INSTANCE.m1461colors1m2CgY(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, $composer2, 0, 805306368, 524287);
                    $dirty &= -29360129;
                } else {
                    colors2 = colors;
                }
            } else {
                $composer2.skipToGroupEnd();
                if ((i & 128) != 0) {
                    modifier2 = modifier;
                    headline = function22;
                    showModeToggle2 = showModeToggle;
                    colors2 = colors;
                    $dirty &= -29360129;
                    title = function23;
                    z = true;
                } else {
                    modifier2 = modifier;
                    headline = function22;
                    showModeToggle2 = showModeToggle;
                    colors2 = colors;
                    title = function23;
                    z = true;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1835392055, $dirty, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:84)");
            }
            ComposableLambda composableLambda = showModeToggle2 ? ComposableLambdaKt.composableLambda($composer2, -1062265737, z, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    Object value$iv$iv2;
                    ComposerKt.sourceInformation($composer3, "C114@5138L163,111@4940L379:DateRangePicker.kt#uh7d8r");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1062265737, $changed2, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:110)");
                        }
                        Modifier padding = PaddingKt.padding(Modifier.INSTANCE, DatePickerKt.getDatePickerModeTogglePadding());
                        int m1476getDisplayModejFl4v0 = DateRangePickerState.this.m1476getDisplayModejFl4v0();
                        Object key1$iv = DateRangePickerState.this;
                        final DateRangePickerState dateRangePickerState = DateRangePickerState.this;
                        int i9 = $dirty & 14;
                        $composer3.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation($composer3, "CC(remember)P(1):Composables.kt#9igjgp");
                        boolean invalid$iv$iv = $composer3.changed(key1$iv);
                        Object it$iv$iv2 = $composer3.rememberedValue();
                        if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv2 = new Function1<DisplayMode, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$5$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(DisplayMode displayMode) {
                                    m1474invokevCnGnXg(displayMode.getValue());
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke-vCnGnXg, reason: not valid java name */
                                public final void m1474invokevCnGnXg(int displayMode) {
                                    DateRangePickerState.this.getStateData().m1713switchDisplayModevCnGnXg(displayMode);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv$iv2);
                        } else {
                            value$iv$iv2 = it$iv$iv2;
                        }
                        $composer3.endReplaceableGroup();
                        DatePickerKt.m1466DisplayModeToggleButtontER2X8s(padding, m1476getDisplayModejFl4v0, (Function1) value$iv$iv2, $composer3, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }) : null;
            TextStyle fromToken = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer2, 6), DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont());
            float arg0$iv = DatePickerModalTokens.INSTANCE.m2113getRangeSelectionHeaderContainerHeightD9Ej5fM();
            float other$iv = HeaderHeightOffset;
            final DatePickerFormatter datePickerFormatter = dateFormatter2;
            final Function1 function12 = dateValidator;
            final DatePickerColors datePickerColors = colors2;
            final int i9 = $dirty;
            DatePickerKt.m1464DateEntryContainerau3_HiA(modifier2, title, headline, composableLambda, colors2, fromToken, Dp.m5218constructorimpl(arg0$iv - other$iv), ComposableLambdaKt.composableLambda($composer2, -186850856, z, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$6
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C131@5679L178:DateRangePicker.kt#uh7d8r");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-186850856, $changed2, -1, "androidx.compose.material3.DateRangePicker.<anonymous> (DateRangePicker.kt:130)");
                        }
                        DateRangePickerKt.SwitchableDateEntryContent(DateRangePickerState.this, datePickerFormatter, function12, datePickerColors, $composer3, (i9 & 14) | ((i9 >> 3) & 112) | ((i9 >> 3) & 896) | ((i9 >> 12) & 7168));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, (($dirty >> 3) & 14) | 14155776 | (($dirty >> 9) & 112) | (($dirty >> 9) & 896) | (($dirty >> 9) & 57344));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            title2 = title;
            headline2 = headline;
            showModeToggle3 = showModeToggle2;
            dateFormatter3 = dateFormatter2;
            colors3 = colors2;
            dateValidator2 = dateValidator;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier4 = modifier2;
        final DatePickerFormatter datePickerFormatter2 = dateFormatter3;
        final Function1 function13 = dateValidator2;
        final Function2 function25 = title2;
        final Function2 function26 = headline2;
        final boolean z2 = showModeToggle3;
        final DatePickerColors datePickerColors2 = colors3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePicker$7
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i10) {
                DateRangePickerKt.DateRangePicker(DateRangePickerState.this, modifier4, datePickerFormatter2, function13, function25, function26, z2, datePickerColors2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* renamed from: rememberDateRangePickerState-pMw4iz8, reason: not valid java name */
    public static final DateRangePickerState m1473rememberDateRangePickerStatepMw4iz8(Long initialSelectedStartDateMillis, Long initialSelectedEndDateMillis, Long initialDisplayedMonthMillis, IntRange yearRange, int initialDisplayMode, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(501019096);
        ComposerKt.sourceInformation($composer, "C(rememberDateRangePickerState)P(3,2,1,4,0:c#material3.DisplayMode)164@7390L384:DateRangePicker.kt#uh7d8r");
        if ((i & 1) != 0) {
            initialSelectedStartDateMillis = null;
        }
        if ((i & 2) != 0) {
            initialSelectedEndDateMillis = null;
        }
        if ((i & 4) != 0) {
            initialDisplayedMonthMillis = initialSelectedStartDateMillis;
        }
        if ((i & 8) != 0) {
            yearRange = DatePickerDefaults.INSTANCE.getYearRange();
        }
        if ((i & 16) != 0) {
            initialDisplayMode = DisplayMode.INSTANCE.m1494getPickerjFl4v0();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(501019096, $changed, -1, "androidx.compose.material3.rememberDateRangePickerState (DateRangePicker.kt:157)");
        }
        final Long l = initialSelectedStartDateMillis;
        final Long l2 = initialSelectedEndDateMillis;
        final Long l3 = initialDisplayedMonthMillis;
        final IntRange intRange = yearRange;
        final int i2 = initialDisplayMode;
        DateRangePickerState dateRangePickerState = (DateRangePickerState) RememberSaveableKt.m2596rememberSaveable(new Object[0], (Saver) DateRangePickerState.INSTANCE.Saver(), (String) null, (Function0) new Function0<DateRangePickerState>() { // from class: androidx.compose.material3.DateRangePickerKt$rememberDateRangePickerState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DateRangePickerState invoke() {
                return new DateRangePickerState(l, l2, l3, intRange, i2, null);
            }
        }, $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return dateRangePickerState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SwitchableDateEntryContent(final DateRangePickerState state, final DatePickerFormatter dateFormatter, final Function1<? super Long, Boolean> function1, final DatePickerColors colors, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(984055784);
        ComposerKt.sourceInformation($composer2, "C(SwitchableDateEntryContent)P(3,1,2)455@19358L648:DateRangePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(state) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(dateFormatter) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(colors) ? 2048 : 1024;
        }
        if (($dirty & 5851) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(984055784, $dirty, -1, "androidx.compose.material3.SwitchableDateEntryContent (DateRangePicker.kt:447)");
            }
            int m1476getDisplayModejFl4v0 = state.m1476getDisplayModejFl4v0();
            final int i = $dirty;
            CrossfadeKt.Crossfade(DisplayMode.m1486boximpl(m1476getDisplayModejFl4v0), SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$SwitchableDateEntryContent$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    SemanticsPropertiesKt.setContainer(semantics, true);
                }
            }, 1, null), AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null), (String) null, ComposableLambdaKt.composableLambda($composer2, 1354418636, true, new Function3<DisplayMode, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$SwitchableDateEntryContent$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(DisplayMode displayMode, Composer composer, Integer num) {
                    m1475invokeQujVXRc(displayMode.getValue(), composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-QujVXRc, reason: not valid java name */
                public final void m1475invokeQujVXRc(int mode, Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "CP(0:c#material3.DisplayMode):DateRangePicker.kt#uh7d8r");
                    int $dirty2 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty2 |= $composer3.changed(mode) ? 4 : 2;
                    }
                    if (($dirty2 & 91) != 18 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1354418636, $changed2, -1, "androidx.compose.material3.SwitchableDateEntryContent.<anonymous> (DateRangePicker.kt:458)");
                        }
                        if (DisplayMode.m1489equalsimpl0(mode, DisplayMode.INSTANCE.m1494getPickerjFl4v0())) {
                            $composer3.startReplaceableGroup(-1168754929);
                            ComposerKt.sourceInformation($composer3, "460@19572L208");
                            DateRangePickerKt.DateRangePickerContent(DateRangePickerState.this.getStateData(), dateFormatter, function1, colors, $composer3, (i & 112) | (i & 896) | (i & 7168));
                            $composer3.endReplaceableGroup();
                        } else if (DisplayMode.m1489equalsimpl0(mode, DisplayMode.INSTANCE.m1493getInputjFl4v0())) {
                            $composer3.startReplaceableGroup(-1168754686);
                            ComposerKt.sourceInformation($composer3, "467@19815L175");
                            DateRangeInputKt.DateRangeInputContent(DateRangePickerState.this.getStateData(), dateFormatter, function1, $composer3, (i & 112) | (i & 896));
                            $composer3.endReplaceableGroup();
                        } else {
                            $composer3.startReplaceableGroup(-1168754501);
                            $composer3.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, 24960, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$SwitchableDateEntryContent$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i2) {
                DateRangePickerKt.SwitchableDateEntryContent(DateRangePickerState.this, dateFormatter, function1, colors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DateRangePickerContent(final StateData stateData, final DatePickerFormatter dateFormatter, final Function1<? super Long, Boolean> function1, final DatePickerColors colors, Composer $composer, final int $changed) {
        Object value$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-1003501610);
        ComposerKt.sourceInformation($composer2, "C(DateRangePickerContent)P(3,1,2)485@20269L105,489@20401L82,492@20488L412:DateRangePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(stateData) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(dateFormatter) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(colors) ? 2048 : 1024;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 5851) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1003501610, $dirty2, -1, "androidx.compose.material3.DateRangePickerContent (DateRangePicker.kt:478)");
            }
            LazyListState monthsListState = LazyListStateKt.rememberLazyListState(stateData.getDisplayedMonthIndex(), 0, $composer2, 0, 2);
            int i = $dirty2 & 14;
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed(stateData);
            Object it$iv$iv = $composer2.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = (Function1) new Function1<Long, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePickerContent$onDateSelected$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                        invoke(l.longValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(long dateInMillis) {
                        DateRangePickerKt.updateDateSelection(StateData.this, dateInMillis);
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            Function1 onDateSelected = (Function1) value$iv$iv;
            Modifier modifier$iv = PaddingKt.m486paddingVpY3zN4$default(Modifier.INSTANCE, DatePickerKt.getDatePickerHorizontalPadding(), 0.0f, 2, null);
            $composer2.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation($composer2, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
            $composer2.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Density density$iv$iv = (Density) consume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume3 = $composer2.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                $composer2.useNode();
            }
            $composer2.disableReusing();
            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2583constructorimpl($composer2);
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            $composer2.enableReusing();
            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
            $composer2.startReplaceableGroup(2058660585);
            int i2 = ($changed$iv$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 276693704, "C79@4027L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i3 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1265369378, "C493@20576L41,494@20626L268:DateRangePicker.kt#uh7d8r");
            DatePickerKt.WeekDays(colors, stateData.getCalendarModel(), $composer2, ($dirty2 >> 9) & 14);
            VerticalMonthsList(onDateSelected, stateData, monthsListState, dateFormatter, function1, colors, $composer2, (($dirty2 << 3) & 112) | (($dirty2 << 6) & 7168) | (($dirty2 << 6) & 57344) | (($dirty2 << 6) & 458752));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endReplaceableGroup();
            $composer2.endNode();
            $composer2.endReplaceableGroup();
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$DateRangePickerContent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i4) {
                DateRangePickerKt.DateRangePickerContent(StateData.this, dateFormatter, function1, colors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void VerticalMonthsList(final Function1<? super Long, Unit> function1, final StateData stateData, final LazyListState lazyListState, final DatePickerFormatter dateFormatter, final Function1<? super Long, Boolean> function12, final DatePickerColors colors, Composer $composer, final int $changed) {
        Object key1$iv;
        Object value$iv$iv;
        Composer $composer2 = $composer.startRestartGroup(-837198453);
        ComposerKt.sourceInformation($composer2, "C(VerticalMonthsList)P(4,5,3,1,2)520@21434L168,527@21647L10,526@21607L2599,584@24241L62,584@24211L92:DateRangePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(stateData) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(lazyListState) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(dateFormatter) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function12) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty |= $composer2.changed(colors) ? 131072 : 65536;
        }
        final int $dirty2 = $dirty;
        if ((374491 & $dirty2) != 74898 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-837198453, $dirty2, -1, "androidx.compose.material3.VerticalMonthsList (DateRangePicker.kt:511)");
            }
            final CalendarDate today = stateData.getCalendarModel().getToday();
            Object key1$iv2 = stateData.getYearRange();
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed(key1$iv2);
            Object it$iv$iv = $composer2.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                CalendarModel calendarModel = stateData.getCalendarModel();
                int $changed$iv = stateData.getYearRange().getFirst();
                key1$iv = calendarModel.getMonth($changed$iv, 1);
                $composer2.updateRememberedValue(key1$iv);
            } else {
                key1$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            final CalendarMonth firstMonth = (CalendarMonth) key1$iv;
            TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer2, 6), DatePickerModalTokens.INSTANCE.getRangeSelectionMonthSubheadFont()), ComposableLambdaKt.composableLambda($composer2, 56792252, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    Object value$iv$iv$iv;
                    ComposerKt.sourceInformation($composer3, "C531@21781L24,532@21847L59,533@21944L55,534@22008L2192:DateRangePicker.kt#uh7d8r");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(56792252, $changed2, -1, "androidx.compose.material3.VerticalMonthsList.<anonymous> (DateRangePicker.kt:530)");
                        }
                        $composer3.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation($composer3, "CC(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
                        $composer3.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer3, "CC(remember):Composables.kt#9igjgp");
                        Object it$iv$iv$iv = $composer3.rememberedValue();
                        if (it$iv$iv$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer3));
                            $composer3.updateRememberedValue(value$iv$iv$iv);
                        } else {
                            value$iv$iv$iv = it$iv$iv$iv;
                        }
                        $composer3.endReplaceableGroup();
                        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
                        final CoroutineScope coroutineScope = wrapper$iv.getCoroutineScope();
                        $composer3.endReplaceableGroup();
                        final String scrollToPreviousMonthLabel = Strings_androidKt.m1785getStringNWtq28(Strings.INSTANCE.m1757getDateRangePickerScrollToShowPreviousMonthadMyvUU(), $composer3, 6);
                        final String scrollToNextMonthLabel = Strings_androidKt.m1785getStringNWtq28(Strings.INSTANCE.m1756getDateRangePickerScrollToShowNextMonthadMyvUU(), $composer3, 6);
                        Modifier semantics$default = SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                SemanticsPropertiesKt.setVerticalScrollAxisRange(semantics, new ScrollAxisRange(new Function0<Float>() { // from class: androidx.compose.material3.DateRangePickerKt.VerticalMonthsList.1.1.1
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Float invoke() {
                                        return Float.valueOf(0.0f);
                                    }
                                }, new Function0<Float>() { // from class: androidx.compose.material3.DateRangePickerKt.VerticalMonthsList.1.1.2
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Float invoke() {
                                        return Float.valueOf(0.0f);
                                    }
                                }, false, 4, null));
                            }
                        }, 1, null);
                        LazyListState lazyListState2 = LazyListState.this;
                        final StateData stateData2 = stateData;
                        final CalendarMonth calendarMonth = firstMonth;
                        final DatePickerFormatter datePickerFormatter = dateFormatter;
                        final DatePickerColors datePickerColors = colors;
                        final Function1<Long, Unit> function13 = function1;
                        final CalendarDate calendarDate = today;
                        final Function1<Long, Boolean> function14 = function12;
                        final int i = $dirty2;
                        final LazyListState lazyListState3 = LazyListState.this;
                        LazyDslKt.LazyColumn(semantics$default, lazyListState2, null, false, null, null, null, false, new Function1<LazyListScope, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                                invoke2(lazyListScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyListScope LazyColumn) {
                                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                                int totalMonthsInRange = StateData.this.getTotalMonthsInRange();
                                final StateData stateData3 = StateData.this;
                                final CalendarMonth calendarMonth2 = calendarMonth;
                                final DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
                                final DatePickerColors datePickerColors2 = datePickerColors;
                                final Function1<Long, Unit> function15 = function13;
                                final CalendarDate calendarDate2 = calendarDate;
                                final Function1<Long, Boolean> function16 = function14;
                                final int i2 = i;
                                final LazyListState lazyListState4 = lazyListState3;
                                final CoroutineScope coroutineScope2 = coroutineScope;
                                final String str = scrollToPreviousMonthLabel;
                                final String str2 = scrollToNextMonthLabel;
                                LazyListScope.items$default(LazyColumn, totalMonthsInRange, null, null, ComposableLambdaKt.composableLambdaInstance(1246706073, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt.VerticalMonthsList.1.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(LazyItemScope items, int it, Composer $composer4, int $changed3) {
                                        String str3;
                                        Intrinsics.checkNotNullParameter(items, "$this$items");
                                        ComposerKt.sourceInformation($composer4, "C548@22622L1554:DateRangePicker.kt#uh7d8r");
                                        int $dirty3 = $changed3;
                                        if (($changed3 & 14) == 0) {
                                            $dirty3 |= $composer4.changed(items) ? 4 : 2;
                                        }
                                        if (($changed3 & 112) == 0) {
                                            $dirty3 |= $composer4.changed(it) ? 32 : 16;
                                        }
                                        if (($dirty3 & 731) != 146 || !$composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1246706073, $changed3, -1, "androidx.compose.material3.VerticalMonthsList.<anonymous>.<anonymous>.<anonymous> (DateRangePicker.kt:542)");
                                            }
                                            CalendarMonth month = StateData.this.getCalendarModel().plusMonths(calendarMonth2, it);
                                            Modifier modifier$iv = LazyItemScope.fillParentMaxWidth$default(items, Modifier.INSTANCE, 0.0f, 1, null);
                                            DatePickerFormatter datePickerFormatter3 = datePickerFormatter2;
                                            StateData stateData4 = StateData.this;
                                            DatePickerColors datePickerColors3 = datePickerColors2;
                                            Function1<Long, Unit> function17 = function15;
                                            CalendarDate calendarDate3 = calendarDate2;
                                            Function1<Long, Boolean> function18 = function16;
                                            int i3 = i2;
                                            final LazyListState lazyListState5 = lazyListState4;
                                            final CoroutineScope coroutineScope3 = coroutineScope2;
                                            final String str4 = str;
                                            final String str5 = str2;
                                            $composer4.startReplaceableGroup(-483455358);
                                            ComposerKt.sourceInformation($composer4, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
                                            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                                            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
                                            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                            int $changed$iv$iv = (0 << 3) & 112;
                                            $composer4.startReplaceableGroup(-1323940314);
                                            ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                                            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object consume = $composer4.consume(localDensity);
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            Density density$iv$iv = (Density) consume;
                                            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object consume2 = $composer4.consume(localLayoutDirection);
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume2;
                                            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                                            ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                            Object consume3 = $composer4.consume(localViewConfiguration);
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume3;
                                            Function0 factory$iv$iv$iv = ComposeUiNode.INSTANCE.getConstructor();
                                            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
                                            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
                                            if (!($composer4.getApplier() instanceof Applier)) {
                                                ComposablesKt.invalidApplier();
                                            }
                                            $composer4.startReusableNode();
                                            if ($composer4.getInserting()) {
                                                $composer4.createNode(factory$iv$iv$iv);
                                            } else {
                                                $composer4.useNode();
                                            }
                                            $composer4.disableReusing();
                                            Composer $this$Layout_u24lambda_u2d0$iv$iv = Updater.m2583constructorimpl($composer4);
                                            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, measurePolicy$iv, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, density$iv$iv, ComposeUiNode.INSTANCE.getSetDensity());
                                            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, layoutDirection$iv$iv, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                            Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv, viewConfiguration$iv$iv, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                            $composer4.enableReusing();
                                            skippableUpdate$iv$iv$iv.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv >> 3) & 112));
                                            $composer4.startReplaceableGroup(2058660585);
                                            int i4 = ($changed$iv$iv$iv >> 9) & 14;
                                            ComposerKt.sourceInformationMarkerStart($composer4, 276693704, "C79@4027L9:Column.kt#2w3rfo");
                                            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                            int i5 = ((0 >> 6) & 112) | 6;
                                            ComposerKt.sourceInformationMarkerStart($composer4, 1680467237, "C555@22915L15,551@22731L992,570@23744L414:DateRangePicker.kt#uh7d8r");
                                            String formatMonthYear$material3_release = datePickerFormatter3.formatMonthYear$material3_release(month, stateData4.getCalendarModel(), CalendarModel_androidKt.defaultLocale($composer4, 0));
                                            if (formatMonthYear$material3_release != null) {
                                                str3 = formatMonthYear$material3_release;
                                            } else {
                                                str3 = "-";
                                            }
                                            TextKt.m1872Text4IGK_g(str3, SemanticsModifierKt.semantics$default(ClickableKt.m196clickableXHw0xAI$default(PaddingKt.padding(Modifier.INSTANCE, DateRangePickerKt.getCalendarMonthSubheadPadding()), false, null, null, new Function0<Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2$1$1$1
                                                @Override // kotlin.jvm.functions.Function0
                                                public /* bridge */ /* synthetic */ Unit invoke() {
                                                    invoke2();
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2() {
                                                }
                                            }, 7, null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$1$2$1$1$2
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                                    invoke2(semanticsPropertyReceiver);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                                public final void invoke2(SemanticsPropertyReceiver semantics) {
                                                    List customScrollActions;
                                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                                    customScrollActions = DateRangePickerKt.customScrollActions(LazyListState.this, coroutineScope3, str4, str5);
                                                    SemanticsPropertiesKt.setCustomActions(semantics, customScrollActions);
                                                }
                                            }, 1, null), datePickerColors3.getSubheadContentColor(), 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer4, 0, 0, 131064);
                                            int i6 = i3 << 3;
                                            int i7 = i3 << 6;
                                            DatePickerKt.Month(month, function17, calendarDate3, stateData4, true, function18, datePickerFormatter3, datePickerColors3, $composer4, (i6 & 458752) | (i6 & 112) | 24576 | (i7 & 7168) | (3670016 & (i3 << 9)) | (29360128 & i7));
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            ComposerKt.sourceInformationMarkerEnd($composer4);
                                            $composer4.endReplaceableGroup();
                                            $composer4.endNode();
                                            $composer4.endReplaceableGroup();
                                            $composer4.endReplaceableGroup();
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        $composer4.skipToGroupEnd();
                                    }
                                }), 6, null);
                            }
                        }, $composer3, ($dirty2 >> 3) & 112, 252);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, 48);
            int i = (($dirty2 >> 6) & 14) | ($dirty2 & 112);
            $composer2.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv2 = $composer2.changed(lazyListState) | $composer2.changed(stateData);
            Object it$iv$iv2 = $composer2.rememberedValue();
            if (invalid$iv$iv2 || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new DateRangePickerKt$VerticalMonthsList$2$1(lazyListState, stateData, null);
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv2;
            }
            $composer2.endReplaceableGroup();
            EffectsKt.LaunchedEffect(lazyListState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv$iv, $composer2, (($dirty2 >> 6) & 14) | 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateRangePickerKt$VerticalMonthsList$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i2) {
                DateRangePickerKt.VerticalMonthsList(function1, stateData, lazyListState, dateFormatter, function12, colors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateDateSelection(StateData stateData, long dateInMillis) {
        CalendarDate date = stateData.getCalendarModel().getCanonicalDate(dateInMillis);
        CalendarDate currentStart = stateData.getSelectedStartDate().getValue();
        CalendarDate currentEnd = stateData.getSelectedEndDate().getValue();
        if ((currentStart == null && currentEnd == null) || ((currentStart != null && currentEnd != null) || (currentStart != null && date.compareTo(currentStart) < 0))) {
            stateData.getSelectedStartDate().setValue(date);
            stateData.getSelectedEndDate().setValue(null);
        } else if (currentStart != null && date.compareTo(currentStart) >= 0) {
            stateData.getSelectedEndDate().setValue(date);
        }
    }

    public static final PaddingValues getCalendarMonthSubheadPadding() {
        return CalendarMonthSubheadPadding;
    }

    /* renamed from: drawRangeBackground-mxwnekA, reason: not valid java name */
    public static final void m1472drawRangeBackgroundmxwnekA(ContentDrawScope drawRangeBackground, SelectedRangeInfo selectedRangeInfo, long color) {
        float m2779getWidthimpl;
        Intrinsics.checkNotNullParameter(drawRangeBackground, "$this$drawRangeBackground");
        Intrinsics.checkNotNullParameter(selectedRangeInfo, "selectedRangeInfo");
        float itemContainerWidth = drawRangeBackground.mo329toPx0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float itemContainerHeight = drawRangeBackground.mo329toPx0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float itemStateLayerHeight = drawRangeBackground.mo329toPx0680j_4(DatePickerModalTokens.INSTANCE.m2106getDateStateLayerHeightD9Ej5fM());
        float f = 2;
        float stateLayerVerticalPadding = (itemContainerHeight - itemStateLayerHeight) / f;
        float f2 = 7;
        float horizontalSpaceBetweenItems = (Size.m2779getWidthimpl(drawRangeBackground.mo3492getSizeNHjbRc()) - (f2 * itemContainerWidth)) / f2;
        long packedValue = selectedRangeInfo.getGridCoordinates().getFirst().getPackedValue();
        int x1 = IntOffset.m5328component1impl(packedValue);
        int y1 = IntOffset.m5329component2impl(packedValue);
        long packedValue2 = selectedRangeInfo.getGridCoordinates().getSecond().getPackedValue();
        int x2 = IntOffset.m5328component1impl(packedValue2);
        int y2 = IntOffset.m5329component2impl(packedValue2);
        float startX = (x1 * (itemContainerWidth + horizontalSpaceBetweenItems)) + (selectedRangeInfo.getFirstIsSelectionStart() ? itemContainerWidth / f : 0.0f) + (horizontalSpaceBetweenItems / f);
        float startY = (y1 * itemContainerHeight) + stateLayerVerticalPadding;
        float endX = (x2 * (itemContainerWidth + horizontalSpaceBetweenItems)) + (selectedRangeInfo.getLastIsSelectionEnd() ? itemContainerWidth / f : itemContainerWidth) + (horizontalSpaceBetweenItems / f);
        float endY = (y2 * itemContainerHeight) + stateLayerVerticalPadding;
        boolean isRtl = drawRangeBackground.getLayoutDirection() == LayoutDirection.Rtl;
        if (isRtl) {
            startX = Size.m2779getWidthimpl(drawRangeBackground.mo3492getSizeNHjbRc()) - startX;
            endX = Size.m2779getWidthimpl(drawRangeBackground.mo3492getSizeNHjbRc()) - endX;
        }
        ContentDrawScope contentDrawScope = drawRangeBackground;
        long Offset = OffsetKt.Offset(startX, startY);
        if (y1 == y2) {
            m2779getWidthimpl = endX - startX;
        } else {
            m2779getWidthimpl = isRtl ? -startX : Size.m2779getWidthimpl(drawRangeBackground.mo3492getSizeNHjbRc()) - startX;
        }
        DrawScope.m3487drawRectnJ9OG0$default(contentDrawScope, color, Offset, SizeKt.Size(m2779getWidthimpl, itemStateLayerHeight), 0.0f, null, null, 0, 120, null);
        if (y1 != y2) {
            int y = (y2 - y1) - 1;
            while (y > 0) {
                DrawScope.m3487drawRectnJ9OG0$default(drawRangeBackground, color, OffsetKt.Offset(0.0f, (y * itemContainerHeight) + startY), SizeKt.Size(Size.m2779getWidthimpl(drawRangeBackground.mo3492getSizeNHjbRc()), itemStateLayerHeight), 0.0f, null, null, 0, 120, null);
                y--;
                itemContainerHeight = itemContainerHeight;
            }
            float topLeftX = drawRangeBackground.getLayoutDirection() == LayoutDirection.Ltr ? 0.0f : Size.m2779getWidthimpl(drawRangeBackground.mo3492getSizeNHjbRc());
            DrawScope.m3487drawRectnJ9OG0$default(drawRangeBackground, color, OffsetKt.Offset(topLeftX, endY), SizeKt.Size(isRtl ? endX - Size.m2779getWidthimpl(drawRangeBackground.mo3492getSizeNHjbRc()) : endX, itemStateLayerHeight), 0.0f, null, null, 0, 120, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<CustomAccessibilityAction> customScrollActions(final LazyListState state, final CoroutineScope coroutineScope, String scrollUpLabel, String scrollDownLabel) {
        Function0 scrollUpAction = new Function0<Boolean>() { // from class: androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollUpAction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z;
                if (LazyListState.this.getCanScrollBackward()) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(LazyListState.this, null), 3, null);
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: DateRangePicker.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(c = "androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollUpAction$1$1", f = "DateRangePicker.kt", i = {}, l = {774}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollUpAction$1$1, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ LazyListState $state;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(LazyListState lazyListState, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$state = lazyListState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$state, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            this.label = 1;
                            if (LazyListState.scrollToItem$default(this.$state, this.$state.getFirstVisibleItemIndex() - 1, 0, this, 2, null) != coroutine_suspended) {
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        case 1:
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }
        };
        Function0 scrollDownAction = new Function0<Boolean>() { // from class: androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollDownAction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z;
                if (LazyListState.this.getCanScrollForward()) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(LazyListState.this, null), 3, null);
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: DateRangePicker.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(c = "androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollDownAction$1$1", f = "DateRangePicker.kt", i = {}, l = {784}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.DateRangePickerKt$customScrollActions$scrollDownAction$1$1, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ LazyListState $state;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(LazyListState lazyListState, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$state = lazyListState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$state, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            this.label = 1;
                            if (LazyListState.scrollToItem$default(this.$state, this.$state.getFirstVisibleItemIndex() + 1, 0, this, 2, null) != coroutine_suspended) {
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        case 1:
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }
        };
        return CollectionsKt.listOf((Object[]) new CustomAccessibilityAction[]{new CustomAccessibilityAction(scrollUpLabel, scrollUpAction), new CustomAccessibilityAction(scrollDownLabel, scrollDownAction)});
    }
}
