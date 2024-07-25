package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
import androidx.compose.material.icons.filled.KeyboardArrowLeftKt;
import androidx.compose.material.icons.filled.KeyboardArrowRightKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.LiveRegionMode;
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
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.profileinstaller.ProfileVerifier;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
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
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: DatePicker.kt */
@Metadata(d1 = {"\u0000¼\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0087\u0001\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0013\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0013\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00032\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u0081\u0001\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010'\u001a\u00020(2\u0014\b\u0002\u0010)\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*2\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\b\b\u0002\u0010-\u001a\u00020,2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007¢\u0006\u0002\u0010.\u001a9\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u0002012\u0006\u0010'\u001a\u00020(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u00102\u001a]\u00103\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0018¢\u0006\u0002\b\u00192\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u00020\u00032\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001an\u0010:\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010;\u001a\u00020,2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010=\u001a\u00020,2\u0006\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u00020,2\u0006\u0010A\u001a\u00020B2\u0006\u0010\u001c\u001a\u00020\u001d2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0003¢\u0006\u0002\u0010C\u001a9\u0010D\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010E\u001a\u00020F2\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020\u00140*H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010I\u001ad\u0010J\u001a\u00020\u00142!\u0010K\u001a\u001d\u0012\u0013\u0012\u00110+¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0004\u0012\u00020\u00140*2\u0006\u00100\u001a\u0002012\u0006\u0010O\u001a\u00020P2\u0006\u0010'\u001a\u00020(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010Q\u001at\u0010R\u001a\u00020\u00142\u0006\u0010S\u001a\u00020T2!\u0010K\u001a\u001d\u0012\u0013\u0012\u00110+¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0004\u0012\u00020\u00140*2\u0006\u0010?\u001a\u00020U2\u0006\u00100\u001a\u0002012\u0006\u0010V\u001a\u00020,2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\u0010W\u001a_\u0010X\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010Y\u001a\u00020,2\u0006\u0010Z\u001a\u00020,2\u0006\u0010[\u001a\u00020,2\u0006\u0010\\\u001a\u00020B2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00140\u0018H\u0003¢\u0006\u0002\u0010`\u001a9\u0010a\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0*2\u0006\u0010\u001c\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010b\u001a\u001d\u0010c\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010d\u001a\u00020eH\u0001¢\u0006\u0002\u0010f\u001aV\u0010g\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010;\u001a\u00020,2\u0006\u0010h\u001a\u00020,2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010A\u001a\u00020B2\u0006\u0010\u001c\u001a\u00020\u001d2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0003¢\u0006\u0002\u0010i\u001aH\u0010j\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162!\u0010k\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(l\u0012\u0004\u0012\u00020\u00140*2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00100\u001a\u000201H\u0003¢\u0006\u0002\u0010m\u001a@\u0010n\u001a\u00020\u00142\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010o\u001a\u00020,2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0003¢\u0006\u0002\u0010p\u001a.\u0010q\u001a\b\u0012\u0004\u0012\u00020s0r2\u0006\u0010%\u001a\u00020t2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020B2\u0006\u0010x\u001a\u00020BH\u0002\u001a7\u0010y\u001a\u0004\u0018\u00010B2\u0006\u0010V\u001a\u00020,2\u0006\u0010z\u001a\u00020,2\u0006\u0010{\u001a\u00020,2\u0006\u0010|\u001a\u00020,2\u0006\u0010}\u001a\u00020,H\u0003¢\u0006\u0002\u0010~\u001aH\u0010\u007f\u001a\u00020&2\u000b\b\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010+2\u000b\b\u0002\u0010\u0081\u0001\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010\u0082\u0001\u001a\u00030\u0083\u00012\t\b\u0002\u0010\u0084\u0001\u001a\u00020FH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a#\u0010\u0087\u0001\u001a\u00020\u00142\u0006\u0010O\u001a\u00020P2\u0006\u00100\u001a\u000201H\u0080@ø\u0001\u0000¢\u0006\u0003\u0010\u0088\u0001\u001a\r\u0010\u0089\u0001\u001a\u00020B*\u00020\fH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0019\u0010\u0002\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000\"\u0019\u0010\r\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u000e\u0010\u0005\"\u0019\u0010\u000f\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0010\u0010\u0005\"\u000e\u0010\u0011\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000\"\u0013\u0010\u0012\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u008a\u0001"}, d2 = {"DatePickerHeadlinePadding", "Landroidx/compose/foundation/layout/PaddingValues;", "DatePickerHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "getDatePickerHorizontalPadding", "()F", "F", "DatePickerModeTogglePadding", "getDatePickerModeTogglePadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "DatePickerTitlePadding", "MaxCalendarRows", "", "MonthYearHeight", "getMonthYearHeight", "RecommendedSizeForAccessibility", "getRecommendedSizeForAccessibility", "YearsInRow", "YearsVerticalPadding", "DateEntryContainer", "", "modifier", "Landroidx/compose/ui/Modifier;", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "headline", "modeToggleButton", "colors", "Landroidx/compose/material3/DatePickerColors;", "headlineTextStyle", "Landroidx/compose/ui/text/TextStyle;", "headerMinHeight", "content", "DateEntryContainer-au3_HiA", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DatePicker", "state", "Landroidx/compose/material3/DatePickerState;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "dateValidator", "Lkotlin/Function1;", "", "", "showModeToggle", "(Landroidx/compose/material3/DatePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "DatePickerContent", "stateData", "Landroidx/compose/material3/StateData;", "(Landroidx/compose/material3/StateData;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "DatePickerHeader", "titleContentColor", "Landroidx/compose/ui/graphics/Color;", "headlineContentColor", "minHeight", "DatePickerHeader-pc5RIQQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Day", "selected", "onClick", "animateChecked", "enabled", "today", "inRange", "description", "", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;ZZZZLjava/lang/String;Landroidx/compose/material3/DatePickerColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DisplayModeToggleButton", "displayMode", "Landroidx/compose/material3/DisplayMode;", "onDisplayModeChange", "DisplayModeToggleButton-tER2X8s", "(Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "HorizontalMonthsList", "onDateSelected", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "dateInMillis", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/StateData;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "Month", "month", "Landroidx/compose/material3/CalendarMonth;", "Landroidx/compose/material3/CalendarDate;", "rangeSelectionEnabled", "(Landroidx/compose/material3/CalendarMonth;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/CalendarDate;Landroidx/compose/material3/StateData;ZLkotlin/jvm/functions/Function1;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "MonthsNavigation", "nextAvailable", "previousAvailable", "yearPickerVisible", "yearPickerText", "onNextClicked", "onPreviousClicked", "onYearPickerButtonClicked", "(Landroidx/compose/ui/Modifier;ZZZLjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "SwitchableDateEntryContent", "(Landroidx/compose/material3/DatePickerState;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "WeekDays", "calendarModel", "Landroidx/compose/material3/CalendarModel;", "(Landroidx/compose/material3/DatePickerColors;Landroidx/compose/material3/CalendarModel;Landroidx/compose/runtime/Composer;I)V", "Year", "currentYear", "(Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function0;Ljava/lang/String;Landroidx/compose/material3/DatePickerColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "YearPicker", "onYearSelected", "year", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/material3/StateData;Landroidx/compose/runtime/Composer;I)V", "YearPickerMenuButton", "expanded", "(Lkotlin/jvm/functions/Function0;ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "customScrollActions", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "scrollUpLabel", "scrollDownLabel", "dayContentDescription", "isToday", "isStartDate", "isEndDate", "isInRange", "(ZZZZZLandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "rememberDatePickerState", "initialSelectedDateMillis", "initialDisplayedMonthMillis", "yearRange", "Lkotlin/ranges/IntRange;", "initialDisplayMode", "rememberDatePickerState-NVmSL94", "(Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DatePickerState;", "updateDisplayedMonth", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/material3/StateData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toLocalString", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DatePickerKt {
    private static final int MaxCalendarRows = 6;
    private static final int YearsInRow = 3;
    private static final float RecommendedSizeForAccessibility = Dp.m5218constructorimpl(48);
    private static final float MonthYearHeight = Dp.m5218constructorimpl(56);
    private static final float DatePickerHorizontalPadding = Dp.m5218constructorimpl(12);
    private static final PaddingValues DatePickerModeTogglePadding = PaddingKt.m481PaddingValuesa9UjIt4$default(0.0f, 0.0f, Dp.m5218constructorimpl(12), Dp.m5218constructorimpl(12), 3, null);
    private static final PaddingValues DatePickerTitlePadding = PaddingKt.m481PaddingValuesa9UjIt4$default(Dp.m5218constructorimpl(24), Dp.m5218constructorimpl(16), Dp.m5218constructorimpl(12), 0.0f, 8, null);
    private static final PaddingValues DatePickerHeadlinePadding = PaddingKt.m481PaddingValuesa9UjIt4$default(Dp.m5218constructorimpl(24), 0.0f, Dp.m5218constructorimpl(12), Dp.m5218constructorimpl(12), 2, null);
    private static final float YearsVerticalPadding = Dp.m5218constructorimpl(16);

    public static final void DatePicker(final DatePickerState state, Modifier modifier, DatePickerFormatter dateFormatter, Function1<? super Long, Boolean> function1, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, boolean showModeToggle, DatePickerColors colors, Composer $composer, final int $changed, final int i) {
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
        Composer $composer2 = $composer.startRestartGroup(-1765097918);
        ComposerKt.sourceInformation($composer2, "C(DatePicker)P(6,4,1,2,7,3,5)152@7324L34,168@7901L8,189@8580L10,170@7918L1043:DatePicker.kt#uh7d8r");
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
                    dateValidator = new Function1<Long, Boolean>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$2
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
                    title = ComposableLambdaKt.composableLambda($composer2, 448469326, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$3
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
                            ComposerKt.sourceInformation($composer3, "C155@7477L109:DatePicker.kt#uh7d8r");
                            if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(448469326, $changed2, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:154)");
                                }
                                DatePickerDefaults datePickerDefaults = DatePickerDefaults.INSTANCE;
                                DatePickerState datePickerState = DatePickerState.this;
                                Modifier.Companion companion = Modifier.INSTANCE;
                                paddingValues = DatePickerKt.DatePickerTitlePadding;
                                datePickerDefaults.DatePickerTitle(datePickerState, PaddingKt.padding(companion, paddingValues), $composer3, ($dirty & 14) | 432, 0);
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
                headline = i7 != 0 ? ComposableLambdaKt.composableLambda($composer2, 1578326756, z, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$4
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
                        ComposerKt.sourceInformation($composer3, "C161@7665L142:DatePicker.kt#uh7d8r");
                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1578326756, $changed2, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:160)");
                            }
                            DatePickerDefaults datePickerDefaults = DatePickerDefaults.INSTANCE;
                            DatePickerState datePickerState = DatePickerState.this;
                            DatePickerFormatter datePickerFormatter = dateFormatter2;
                            Modifier.Companion companion = Modifier.INSTANCE;
                            paddingValues = DatePickerKt.DatePickerHeadlinePadding;
                            datePickerDefaults.DatePickerHeadline(datePickerState, datePickerFormatter, PaddingKt.padding(companion, paddingValues), $composer3, ($dirty & 14) | 3456 | (($dirty >> 3) & 112), 0);
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
                ComposerKt.traceEventStart(-1765097918, $dirty, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:149)");
            }
            final DatePickerFormatter datePickerFormatter = dateFormatter2;
            final Function1 function12 = dateValidator;
            final DatePickerColors datePickerColors = colors2;
            final int i9 = $dirty;
            m1464DateEntryContainerau3_HiA(modifier2, title, headline, showModeToggle2 ? ComposableLambdaKt.composableLambda($composer2, -1702543532, z, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5
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
                    ComposerKt.sourceInformation($composer3, "C179@8296L163,176@8098L380:DatePicker.kt#uh7d8r");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1702543532, $changed2, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:175)");
                        }
                        Modifier padding = PaddingKt.padding(Modifier.INSTANCE, DatePickerKt.getDatePickerModeTogglePadding());
                        int m1470getDisplayModejFl4v0 = DatePickerState.this.m1470getDisplayModejFl4v0();
                        Object key1$iv = DatePickerState.this;
                        final DatePickerState datePickerState = DatePickerState.this;
                        int i10 = $dirty & 14;
                        $composer3.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation($composer3, "CC(remember)P(1):Composables.kt#9igjgp");
                        boolean invalid$iv$iv = $composer3.changed(key1$iv);
                        Object it$iv$iv2 = $composer3.rememberedValue();
                        if (invalid$iv$iv || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv2 = new Function1<DisplayMode, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$5$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(DisplayMode displayMode) {
                                    m1468invokevCnGnXg(displayMode.getValue());
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke-vCnGnXg, reason: not valid java name */
                                public final void m1468invokevCnGnXg(int displayMode) {
                                    DatePickerState.this.getStateData().m1713switchDisplayModevCnGnXg(displayMode);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv$iv2);
                        } else {
                            value$iv$iv2 = it$iv$iv2;
                        }
                        $composer3.endReplaceableGroup();
                        DatePickerKt.m1466DisplayModeToggleButtontER2X8s(padding, m1470getDisplayModejFl4v0, (Function1) value$iv$iv2, $composer3, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }) : null, colors2, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer2, 6), DatePickerModalTokens.INSTANCE.getHeaderHeadlineFont()), DatePickerModalTokens.INSTANCE.m2109getHeaderContainerHeightD9Ej5fM(), ComposableLambdaKt.composableLambda($composer2, 173769747, z, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$6
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
                    ComposerKt.sourceInformation($composer3, "C195@8777L178:DatePicker.kt#uh7d8r");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(173769747, $changed2, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:194)");
                        }
                        DatePickerKt.SwitchableDateEntryContent(DatePickerState.this, datePickerFormatter, function12, datePickerColors, $composer3, (i9 & 14) | ((i9 >> 3) & 112) | ((i9 >> 3) & 896) | ((i9 >> 12) & 7168));
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePicker$7
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
                DatePickerKt.DatePicker(DatePickerState.this, modifier4, datePickerFormatter2, function13, function25, function26, z2, datePickerColors2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* renamed from: rememberDatePickerState-NVmSL94, reason: not valid java name */
    public static final DatePickerState m1467rememberDatePickerStateNVmSL94(final Long initialSelectedDateMillis, final Long initialDisplayedMonthMillis, final IntRange yearRange, final int initialDisplayMode, Composer $composer, int $changed, int i) {
        $composer.startReplaceableGroup(1574672255);
        ComposerKt.sourceInformation($composer, "C(rememberDatePickerState)P(2,1,3,0:c#material3.DisplayMode)224@10177L295:DatePicker.kt#uh7d8r");
        if ((i & 1) != 0) {
            initialSelectedDateMillis = null;
        }
        if ((i & 2) != 0) {
            initialDisplayedMonthMillis = initialSelectedDateMillis;
        }
        if ((i & 4) != 0) {
            yearRange = DatePickerDefaults.INSTANCE.getYearRange();
        }
        if ((i & 8) != 0) {
            initialDisplayMode = DisplayMode.INSTANCE.m1494getPickerjFl4v0();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1574672255, $changed, -1, "androidx.compose.material3.rememberDatePickerState (DatePicker.kt:219)");
        }
        DatePickerState datePickerState = (DatePickerState) RememberSaveableKt.m2596rememberSaveable(new Object[0], (Saver) DatePickerState.INSTANCE.Saver(), (String) null, (Function0) new Function0<DatePickerState>() { // from class: androidx.compose.material3.DatePickerKt$rememberDatePickerState$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DatePickerState invoke() {
                return new DatePickerState(initialSelectedDateMillis, initialDisplayedMonthMillis, yearRange, initialDisplayMode, null);
            }
        }, $composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return datePickerState;
    }

    /* renamed from: DateEntryContainer-au3_HiA, reason: not valid java name */
    public static final void m1464DateEntryContainerau3_HiA(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final DatePickerColors colors, final TextStyle headlineTextStyle, final float headerMinHeight, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(headlineTextStyle, "headlineTextStyle");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(1507356255);
        ComposerKt.sourceInformation($composer2, "C(DateEntryContainer)P(6,7,3,5!1,4,2:c#ui.unit.Dp)1021@43152L1610:DatePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(function22) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function23) ? 2048 : 1024;
        }
        if (($changed & 57344) == 0) {
            $dirty |= $composer2.changed(colors) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty |= $composer2.changed(headlineTextStyle) ? 131072 : 65536;
        }
        if ((3670016 & $changed) == 0) {
            $dirty |= $composer2.changed(headerMinHeight) ? 1048576 : 524288;
        }
        if ((29360128 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 8388608 : 4194304;
        }
        final int $dirty2 = $dirty;
        if ((23967451 & $dirty2) != 4793490 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1507356255, $dirty2, -1, "androidx.compose.material3.DateEntryContainer (DatePicker.kt:1011)");
            }
            Modifier modifier$iv = SemanticsModifierKt.semantics$default(SizeKt.m535sizeInqDBjuR0$default(modifier, DatePickerModalTokens.INSTANCE.m2103getContainerWidthD9Ej5fM(), 0.0f, 0.0f, 0.0f, 14, null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DateEntryContainer$1
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
            }, 1, null);
            $composer2.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation($composer2, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
            int $changed$iv$iv = (0 << 3) & 112;
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
            int i = ($changed$iv$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 276693704, "C79@4027L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -916081480, "C1026@43319L1419,1059@44747L9:DatePicker.kt#uh7d8r");
            m1465DatePickerHeaderpc5RIQQ(Modifier.INSTANCE, function2, colors.getTitleContentColor(), colors.getHeadlineContentColor(), headerMinHeight, ComposableLambdaKt.composableLambda($composer2, -229007058, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DateEntryContainer$2$1
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
                    Arrangement.HorizontalOrVertical horizontalArrangement;
                    ComposerKt.sourceInformation($composer3, "C1033@43583L1145:DatePicker.kt#uh7d8r");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-229007058, $changed2, -1, "androidx.compose.material3.DateEntryContainer.<anonymous>.<anonymous> (DatePicker.kt:1032)");
                        }
                        Modifier modifier$iv2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        final Function2<Composer, Integer, Unit> function24 = function22;
                        Function2<Composer, Integer, Unit> function25 = function23;
                        Function2<Composer, Integer, Unit> function26 = function2;
                        TextStyle textStyle = headlineTextStyle;
                        final int i3 = $dirty2;
                        $composer3.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation($composer3, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv2 = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv2 = Alignment.INSTANCE.getStart();
                        MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer3, ((6 >> 3) & 14) | ((6 >> 3) & 112));
                        int $changed$iv$iv2 = (6 << 3) & 112;
                        $composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume4 = $composer3.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Density density$iv$iv2 = (Density) consume4;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume5 = $composer3.consume(localLayoutDirection2);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume6 = $composer3.consume(localViewConfiguration2);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                        Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            $composer3.createNode(factory$iv$iv$iv2);
                        } else {
                            $composer3.useNode();
                        }
                        $composer3.disableReusing();
                        Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2583constructorimpl($composer3);
                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        $composer3.enableReusing();
                        skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                        $composer3.startReplaceableGroup(2058660585);
                        int i4 = ($changed$iv$iv$iv2 >> 9) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 276693704, "C79@4027L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                        int i5 = ((6 >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1449811391, "C1039@43908L580:DatePicker.kt#uh7d8r");
                        if (function24 == null || function25 == null) {
                            horizontalArrangement = function24 != null ? Arrangement.INSTANCE.getStart() : Arrangement.INSTANCE.getEnd();
                        } else {
                            horizontalArrangement = Arrangement.INSTANCE.getSpaceBetween();
                        }
                        Modifier modifier$iv3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
                        $composer3.startReplaceableGroup(693286680);
                        ComposerKt.sourceInformation($composer3, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement, verticalAlignment$iv, $composer3, ((390 >> 3) & 14) | ((390 >> 3) & 112));
                        int $changed$iv$iv3 = (390 << 3) & 112;
                        $composer3.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation($composer3, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                        ProvidableCompositionLocal<Density> localDensity3 = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume7 = $composer3.consume(localDensity3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        Density density$iv$iv3 = (Density) consume7;
                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume8 = $composer3.consume(localLayoutDirection3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        LayoutDirection layoutDirection$iv$iv3 = (LayoutDirection) consume8;
                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration3 = CompositionLocalsKt.getLocalViewConfiguration();
                        ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "C:CompositionLocal.kt#9igjgp");
                        Object consume9 = $composer3.consume(localViewConfiguration3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ViewConfiguration viewConfiguration$iv$iv3 = (ViewConfiguration) consume9;
                        Function0 factory$iv$iv$iv3 = ComposeUiNode.INSTANCE.getConstructor();
                        Function3 skippableUpdate$iv$iv$iv3 = LayoutKt.materializerOf(modifier$iv3);
                        int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 9) & 7168) | 6;
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            $composer3.createNode(factory$iv$iv$iv3);
                        } else {
                            $composer3.useNode();
                        }
                        $composer3.disableReusing();
                        Composer $this$Layout_u24lambda_u2d0$iv$iv3 = Updater.m2583constructorimpl($composer3);
                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv3, measurePolicy$iv3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv3, density$iv$iv3, ComposeUiNode.INSTANCE.getSetDensity());
                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv3, layoutDirection$iv$iv3, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv3, viewConfiguration$iv$iv3, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                        $composer3.enableReusing();
                        skippableUpdate$iv$iv$iv3.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer3)), $composer3, Integer.valueOf(($changed$iv$iv$iv3 >> 3) & 112));
                        $composer3.startReplaceableGroup(2058660585);
                        int i6 = ($changed$iv$iv$iv3 >> 9) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, -326682283, "C80@4021L9:Row.kt#2w3rfo");
                        int i7 = ((390 >> 6) & 112) | 6;
                        final RowScope $this$invoke_u24lambda_u241_u24lambda_u240 = RowScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1011378861, "C:DatePicker.kt#uh7d8r");
                        $composer3.startReplaceableGroup(-1011378861);
                        ComposerKt.sourceInformation($composer3, "1045@44191L210");
                        if (function24 != null) {
                            TextKt.ProvideTextStyle(textStyle, ComposableLambdaKt.composableLambda($composer3, -962031352, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DateEntryContainer$2$1$1$1$1
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

                                public final void invoke(Composer $composer4, int $changed3) {
                                    ComposerKt.sourceInformation($composer4, "C1046@44265L110:DatePicker.kt#uh7d8r");
                                    if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-962031352, $changed3, -1, "androidx.compose.material3.DateEntryContainer.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1045)");
                                        }
                                        Modifier modifier$iv4 = RowScope.weight$default(RowScope.this, Modifier.INSTANCE, 1.0f, false, 2, null);
                                        Function2<Composer, Integer, Unit> function27 = function24;
                                        int i8 = i3;
                                        $composer4.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                        Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                        MeasurePolicy measurePolicy$iv4 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                                        int $changed$iv$iv4 = (0 << 3) & 112;
                                        $composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        ProvidableCompositionLocal<Density> localDensity4 = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume10 = $composer4.consume(localDensity4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        Density density$iv$iv4 = (Density) consume10;
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection4 = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume11 = $composer4.consume(localLayoutDirection4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        LayoutDirection layoutDirection$iv$iv4 = (LayoutDirection) consume11;
                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration4 = CompositionLocalsKt.getLocalViewConfiguration();
                                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume12 = $composer4.consume(localViewConfiguration4);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ViewConfiguration viewConfiguration$iv$iv4 = (ViewConfiguration) consume12;
                                        Function0 factory$iv$iv$iv4 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3 skippableUpdate$iv$iv$iv4 = LayoutKt.materializerOf(modifier$iv4);
                                        int $changed$iv$iv$iv4 = (($changed$iv$iv4 << 9) & 7168) | 6;
                                        if (!($composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer4.startReusableNode();
                                        if ($composer4.getInserting()) {
                                            $composer4.createNode(factory$iv$iv$iv4);
                                        } else {
                                            $composer4.useNode();
                                        }
                                        $composer4.disableReusing();
                                        Composer $this$Layout_u24lambda_u2d0$iv$iv4 = Updater.m2583constructorimpl($composer4);
                                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv4, measurePolicy$iv4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv4, density$iv$iv4, ComposeUiNode.INSTANCE.getSetDensity());
                                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv4, layoutDirection$iv$iv4, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv4, viewConfiguration$iv$iv4, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                        $composer4.enableReusing();
                                        skippableUpdate$iv$iv$iv4.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv4 >> 3) & 112));
                                        $composer4.startReplaceableGroup(2058660585);
                                        int i9 = ($changed$iv$iv$iv4 >> 9) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        int i10 = ((0 >> 6) & 112) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer4, 2128807125, "C1047@44335L10:DatePicker.kt#uh7d8r");
                                        function27.invoke($composer4, Integer.valueOf((i8 >> 6) & 14));
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
                            }), $composer3, ((i3 >> 15) & 14) | 48);
                        }
                        $composer3.endReplaceableGroup();
                        $composer3.startReplaceableGroup(1449812209);
                        ComposerKt.sourceInformation($composer3, "1051@44462L8");
                        if (function25 != null) {
                            function25.invoke($composer3, Integer.valueOf((i3 >> 9) & 14));
                        }
                        $composer3.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endReplaceableGroup();
                        $composer3.endNode();
                        $composer3.endReplaceableGroup();
                        $composer3.endReplaceableGroup();
                        $composer3.startReplaceableGroup(1680507480);
                        ComposerKt.sourceInformation($composer3, "1055@44687L9");
                        if (function26 != null || function24 != null || function25 != null) {
                            DividerKt.m1496Divider9IZ8Weo(null, 0.0f, 0L, $composer3, 0, 7);
                        }
                        $composer3.endReplaceableGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endReplaceableGroup();
                        $composer3.endNode();
                        $composer3.endReplaceableGroup();
                        $composer3.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, ($dirty2 & 112) | 196614 | (($dirty2 >> 6) & 57344));
            content.invoke($composer2, Integer.valueOf(($dirty2 >> 21) & 14));
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DateEntryContainer$3
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

            public final void invoke(Composer composer, int i3) {
                DatePickerKt.m1464DateEntryContainerau3_HiA(Modifier.this, function2, function22, function23, colors, headlineTextStyle, headerMinHeight, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    /* renamed from: DisplayModeToggleButton-tER2X8s, reason: not valid java name */
    public static final void m1466DisplayModeToggleButtontER2X8s(final Modifier modifier, final int displayMode, final Function1<? super DisplayMode, Unit> onDisplayModeChange, Composer $composer, final int $changed) {
        Object value$iv$iv;
        Object value$iv$iv2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(onDisplayModeChange, "onDisplayModeChange");
        Composer $composer2 = $composer.startRestartGroup(1393846115);
        ComposerKt.sourceInformation($composer2, "C(DisplayModeToggleButton)P(1,0:c#material3.DisplayMode):DatePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(displayMode) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changedInstance(onDisplayModeChange) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 731) != 146 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1393846115, $dirty2, -1, "androidx.compose.material3.DisplayModeToggleButton (DatePicker.kt:1065)");
            }
            if (!DisplayMode.m1489equalsimpl0(displayMode, DisplayMode.INSTANCE.m1494getPickerjFl4v0())) {
                $composer2.startReplaceableGroup(-1814971040);
                ComposerKt.sourceInformation($composer2, "1078@45319L43,1078@45298L271");
                int i = ($dirty2 >> 6) & 14;
                $composer2.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer2.changed(onDisplayModeChange);
                Object it$iv$iv = $composer2.rememberedValue();
                if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = new Function0<Unit>() { // from class: androidx.compose.material3.DatePickerKt$DisplayModeToggleButton$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            onDisplayModeChange.invoke(DisplayMode.m1486boximpl(DisplayMode.INSTANCE.m1494getPickerjFl4v0()));
                        }
                    };
                    $composer2.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer2.endReplaceableGroup();
                IconButtonKt.IconButton((Function0) value$iv$iv, modifier, false, null, null, ComposableSingletons$DatePickerKt.INSTANCE.m1435getLambda2$material3_release(), $composer2, (($dirty2 << 3) & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                $composer2.endReplaceableGroup();
            } else {
                $composer2.startReplaceableGroup(-1814971324);
                ComposerKt.sourceInformation($composer2, "1071@45035L42,1071@45014L262");
                int i2 = ($dirty2 >> 6) & 14;
                $composer2.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv2 = $composer2.changed(onDisplayModeChange);
                Object it$iv$iv2 = $composer2.rememberedValue();
                if (invalid$iv$iv2 || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv2 = new Function0<Unit>() { // from class: androidx.compose.material3.DatePickerKt$DisplayModeToggleButton$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            onDisplayModeChange.invoke(DisplayMode.m1486boximpl(DisplayMode.INSTANCE.m1493getInputjFl4v0()));
                        }
                    };
                    $composer2.updateRememberedValue(value$iv$iv2);
                } else {
                    value$iv$iv2 = it$iv$iv2;
                }
                $composer2.endReplaceableGroup();
                IconButtonKt.IconButton((Function0) value$iv$iv2, modifier, false, null, null, ComposableSingletons$DatePickerKt.INSTANCE.m1434getLambda1$material3_release(), $composer2, (($dirty2 << 3) & 112) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
                $composer2.endReplaceableGroup();
            }
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DisplayModeToggleButton$3
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

            public final void invoke(Composer composer, int i3) {
                DatePickerKt.m1466DisplayModeToggleButtontER2X8s(Modifier.this, displayMode, onDisplayModeChange, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SwitchableDateEntryContent(final DatePickerState state, final DatePickerFormatter dateFormatter, final Function1<? super Long, Boolean> function1, final DatePickerColors colors, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1613036224);
        ComposerKt.sourceInformation($composer2, "C(SwitchableDateEntryContent)P(3,1,2)1101@46104L638:DatePicker.kt#uh7d8r");
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
                ComposerKt.traceEventStart(1613036224, $dirty, -1, "androidx.compose.material3.SwitchableDateEntryContent (DatePicker.kt:1093)");
            }
            int m1470getDisplayModejFl4v0 = state.m1470getDisplayModejFl4v0();
            final int i = $dirty;
            CrossfadeKt.Crossfade(DisplayMode.m1486boximpl(m1470getDisplayModejFl4v0), SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$1
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
            }, 1, null), AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null), (String) null, ComposableLambdaKt.composableLambda($composer2, 1854706084, true, new Function3<DisplayMode, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(DisplayMode displayMode, Composer composer, Integer num) {
                    m1469invokeQujVXRc(displayMode.getValue(), composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-QujVXRc, reason: not valid java name */
                public final void m1469invokeQujVXRc(int mode, Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "CP(0:c#material3.DisplayMode):DatePicker.kt#uh7d8r");
                    int $dirty2 = $changed2;
                    if (($changed2 & 14) == 0) {
                        $dirty2 |= $composer3.changed(mode) ? 4 : 2;
                    }
                    if (($dirty2 & 91) != 18 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1854706084, $changed2, -1, "androidx.compose.material3.SwitchableDateEntryContent.<anonymous> (DatePicker.kt:1104)");
                        }
                        if (DisplayMode.m1489equalsimpl0(mode, DisplayMode.INSTANCE.m1494getPickerjFl4v0())) {
                            $composer3.startReplaceableGroup(-1168728183);
                            ComposerKt.sourceInformation($composer3, "1106@46318L203");
                            DatePickerKt.DatePickerContent(DatePickerState.this.getStateData(), dateFormatter, function1, colors, $composer3, (i & 112) | (i & 896) | (i & 7168));
                            $composer3.endReplaceableGroup();
                        } else if (DisplayMode.m1489equalsimpl0(mode, DisplayMode.INSTANCE.m1493getInputjFl4v0())) {
                            $composer3.startReplaceableGroup(-1168727945);
                            ComposerKt.sourceInformation($composer3, "1113@46556L170");
                            DateInputKt.DateInputContent(DatePickerState.this.getStateData(), dateFormatter, function1, $composer3, (i & 112) | (i & 896));
                            $composer3.endReplaceableGroup();
                        } else {
                            $composer3.startReplaceableGroup(-1168727765);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$SwitchableDateEntryContent$3
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
                DatePickerKt.SwitchableDateEntryContent(DatePickerState.this, dateFormatter, function1, colors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:52:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0529  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0535  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x06bb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x021a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void DatePickerContent(final androidx.compose.material3.StateData r83, final androidx.compose.material3.DatePickerFormatter r84, final kotlin.jvm.functions.Function1<? super java.lang.Long, java.lang.Boolean> r85, final androidx.compose.material3.DatePickerColors r86, androidx.compose.runtime.Composer r87, final int r88) {
        /*
            Method dump skipped, instructions count: 1755
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt.DatePickerContent(androidx.compose.material3.StateData, androidx.compose.material3.DatePickerFormatter, kotlin.jvm.functions.Function1, androidx.compose.material3.DatePickerColors, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean DatePickerContent$lambda$5(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DatePickerContent$lambda$6(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }

    /* renamed from: DatePickerHeader-pc5RIQQ, reason: not valid java name */
    public static final void m1465DatePickerHeaderpc5RIQQ(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final long titleContentColor, final long headlineContentColor, final float minHeight, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed) {
        Modifier.Companion heightModifier;
        int $changed$iv;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-996037719);
        ComposerKt.sourceInformation($composer2, "C(DatePickerHeader)P(3,4,5:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.unit.Dp)1243@51983L784:DatePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(titleContentColor) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(headlineContentColor) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty |= $composer2.changed(minHeight) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 131072 : 65536;
        }
        final int $dirty2 = $dirty;
        if ((374491 & $dirty2) != 74898 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-996037719, $dirty2, -1, "androidx.compose.material3.DatePickerHeader (DatePicker.kt:1228)");
            }
            if (function2 != null) {
                heightModifier = SizeKt.m516defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, minHeight, 1, null);
            } else {
                heightModifier = Modifier.INSTANCE;
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null).then(heightModifier);
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            $composer2.startReplaceableGroup(-483455358);
            ComposerKt.sourceInformation($composer2, "CC(Column)P(2,3,1)77@3913L61,78@3979L133:Column.kt#2w3rfo");
            Alignment.Horizontal horizontalAlignment$iv = Alignment.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((48 >> 3) & 14) | ((48 >> 3) & 112));
            int $changed$iv$iv = (48 << 3) & 112;
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
            int i = ($changed$iv$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 276693704, "C79@4027L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i2 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1127524835, "C1262@52647L114:DatePicker.kt#uh7d8r");
            $composer2.startReplaceableGroup(1127524835);
            ComposerKt.sourceInformation($composer2, "1250@52175L453");
            if (function2 != null) {
                $changed$iv = 1;
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2939boximpl(titleContentColor))}, ComposableLambdaKt.composableLambda($composer2, 1005061498, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerHeader$1$1
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
                        ComposerKt.sourceInformation($composer3, "C1252@52314L10,1255@52445L169:DatePicker.kt#uh7d8r");
                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1005061498, $changed2, -1, "androidx.compose.material3.DatePickerHeader.<anonymous>.<anonymous> (DatePicker.kt:1250)");
                            }
                            TextStyle textStyle = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), DatePickerModalTokens.INSTANCE.getHeaderSupportingTextFont());
                            final Function2<Composer, Integer, Unit> function22 = function2;
                            final int i3 = $dirty2;
                            TextKt.ProvideTextStyle(textStyle, ComposableLambdaKt.composableLambda($composer3, -2006650069, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerHeader$1$1.1
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

                                public final void invoke(Composer $composer4, int $changed3) {
                                    ComposerKt.sourceInformation($composer4, "C1256@52495L101:DatePicker.kt#uh7d8r");
                                    if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2006650069, $changed3, -1, "androidx.compose.material3.DatePickerHeader.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1255)");
                                        }
                                        Alignment contentAlignment$iv = Alignment.INSTANCE.getBottomStart();
                                        Function2<Composer, Integer, Unit> function23 = function22;
                                        int i4 = i3;
                                        $composer4.startReplaceableGroup(733328855);
                                        ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                        Modifier modifier$iv2 = Modifier.INSTANCE;
                                        MeasurePolicy measurePolicy$iv2 = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((48 >> 3) & 14) | ((48 >> 3) & 112));
                                        int $changed$iv$iv2 = (48 << 3) & 112;
                                        $composer4.startReplaceableGroup(-1323940314);
                                        ComposerKt.sourceInformation($composer4, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                                        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume4 = $composer4.consume(localDensity2);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        Density density$iv$iv2 = (Density) consume4;
                                        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume5 = $composer4.consume(localLayoutDirection2);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                                        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                                        ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, "C:CompositionLocal.kt#9igjgp");
                                        Object consume6 = $composer4.consume(localViewConfiguration2);
                                        ComposerKt.sourceInformationMarkerEnd($composer4);
                                        ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                                        Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
                                        Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
                                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                                        if (!($composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        $composer4.startReusableNode();
                                        if ($composer4.getInserting()) {
                                            $composer4.createNode(factory$iv$iv$iv2);
                                        } else {
                                            $composer4.useNode();
                                        }
                                        $composer4.disableReusing();
                                        Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2583constructorimpl($composer4);
                                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                                        Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                                        $composer4.enableReusing();
                                        skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer4)), $composer4, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                                        $composer4.startReplaceableGroup(2058660585);
                                        int i5 = ($changed$iv$iv$iv2 >> 9) & 14;
                                        ComposerKt.sourceInformationMarkerStart($composer4, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        int i6 = ((48 >> 6) & 112) | 6;
                                        ComposerKt.sourceInformationMarkerStart($composer4, 1812348655, "C1257@52567L7:DatePicker.kt#uh7d8r");
                                        function23.invoke($composer4, Integer.valueOf((i4 >> 3) & 14));
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
                            }), $composer3, 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }), $composer2, 56);
            } else {
                $changed$iv = 1;
            }
            $composer2.endReplaceableGroup();
            ProvidedValue[] providedValueArr = new ProvidedValue[$changed$iv];
            providedValueArr[0] = ContentColorKt.getLocalContentColor().provides(Color.m2939boximpl(headlineContentColor));
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, content, $composer2, (($dirty2 >> 12) & 112) | 8);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$DatePickerHeader$2
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

            public final void invoke(Composer composer, int i3) {
                DatePickerKt.m1465DatePickerHeaderpc5RIQQ(Modifier.this, function2, titleContentColor, headlineContentColor, minHeight, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HorizontalMonthsList(final Function1<? super Long, Unit> function1, final StateData stateData, final LazyListState lazyListState, final DatePickerFormatter dateFormatter, final Function1<? super Long, Boolean> function12, final DatePickerColors colors, Composer $composer, final int $changed) {
        final int $dirty;
        Composer $composer2;
        Object value$iv$iv;
        Composer $composer3 = $composer.startRestartGroup(1933363608);
        ComposerKt.sourceInformation($composer3, "C(HorizontalMonthsList)P(4,5,3,1,2)1282@53204L168,1298@53968L40,1299@54015L738,1288@53377L1376,1323@54789L62,1323@54759L92:DatePicker.kt#uh7d8r");
        int $dirty2 = $changed;
        if (($changed & 14) == 0) {
            $dirty2 |= $composer3.changedInstance(function1) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty2 |= $composer3.changed(stateData) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty2 |= $composer3.changed(lazyListState) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty2 |= $composer3.changed(dateFormatter) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty2 |= $composer3.changedInstance(function12) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty2 |= $composer3.changed(colors) ? 131072 : 65536;
        }
        int $dirty3 = $dirty2;
        if ((374491 & $dirty3) != 74898 || !$composer3.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1933363608, $dirty3, -1, "androidx.compose.material3.HorizontalMonthsList (DatePicker.kt:1273)");
            }
            final CalendarDate today = stateData.getCalendarModel().getToday();
            Object key1$iv = stateData.getYearRange();
            $composer3.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer3, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer3.changed(key1$iv);
            Object value$iv$iv2 = $composer3.rememberedValue();
            if (invalid$iv$iv || value$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = stateData.getCalendarModel().getMonth(stateData.getYearRange().getFirst(), 1);
                $composer3.updateRememberedValue(value$iv$iv2);
            }
            $composer3.endReplaceableGroup();
            final CalendarMonth firstMonth = (CalendarMonth) value$iv$iv2;
            Modifier semantics$default = SemanticsModifierKt.semantics$default(Modifier.INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    invoke2(semanticsPropertyReceiver);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SemanticsPropertyReceiver semantics) {
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    SemanticsPropertiesKt.setHorizontalScrollAxisRange(semantics, new ScrollAxisRange(new Function0<Float>() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1.1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Float invoke() {
                            return Float.valueOf(0.0f);
                        }
                    }, new Function0<Float>() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1.2
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Float invoke() {
                            return Float.valueOf(0.0f);
                        }
                    }, false, 4, null));
                }
            }, 1, null);
            FlingBehavior rememberSnapFlingBehavior$material3_release = DatePickerDefaults.INSTANCE.rememberSnapFlingBehavior$material3_release(lazyListState, null, $composer3, (($dirty3 >> 6) & 14) | 384, 2);
            Object[] keys$iv = {stateData, firstMonth, function1, today, function12, dateFormatter, colors};
            $composer3.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation($composer3, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv = false;
            for (Object key$iv : keys$iv) {
                invalid$iv |= $composer3.changed(key$iv);
            }
            Object value$iv$iv3 = $composer3.rememberedValue();
            if (invalid$iv || value$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                $dirty = $dirty3;
                value$iv$iv3 = new Function1<LazyListScope, Unit>() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                    public final void invoke2(LazyListScope LazyRow) {
                        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
                        int totalMonthsInRange = StateData.this.getTotalMonthsInRange();
                        final StateData stateData2 = StateData.this;
                        final CalendarMonth calendarMonth = firstMonth;
                        final Function1<Long, Unit> function13 = function1;
                        final CalendarDate calendarDate = today;
                        final Function1<Long, Boolean> function14 = function12;
                        final DatePickerFormatter datePickerFormatter = dateFormatter;
                        final DatePickerColors datePickerColors = colors;
                        final int i = $dirty;
                        LazyListScope.items$default(LazyRow, totalMonthsInRange, null, null, ComposableLambdaKt.composableLambdaInstance(-65053693, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$2$1.1
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

                            public final void invoke(LazyItemScope items, int it, Composer $composer4, int $changed2) {
                                Intrinsics.checkNotNullParameter(items, "$this$items");
                                ComposerKt.sourceInformation($composer4, "C1306@54250L487:DatePicker.kt#uh7d8r");
                                int $dirty4 = $changed2;
                                if (($changed2 & 14) == 0) {
                                    $dirty4 |= $composer4.changed(items) ? 4 : 2;
                                }
                                if (($changed2 & 112) == 0) {
                                    $dirty4 |= $composer4.changed(it) ? 32 : 16;
                                }
                                if (($dirty4 & 731) != 146 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-65053693, $changed2, -1, "androidx.compose.material3.HorizontalMonthsList.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1300)");
                                    }
                                    CalendarMonth month = StateData.this.getCalendarModel().plusMonths(calendarMonth, it);
                                    Modifier modifier$iv = LazyItemScope.fillParentMaxWidth$default(items, Modifier.INSTANCE, 0.0f, 1, null);
                                    Function1<Long, Unit> function15 = function13;
                                    CalendarDate calendarDate2 = calendarDate;
                                    StateData stateData3 = StateData.this;
                                    Function1<Long, Boolean> function16 = function14;
                                    DatePickerFormatter datePickerFormatter2 = datePickerFormatter;
                                    DatePickerColors datePickerColors2 = datePickerColors;
                                    int i2 = i;
                                    $composer4.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation($composer4, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                                    MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, false, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & 112));
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
                                    int i3 = ($changed$iv$iv$iv >> 9) & 14;
                                    ComposerKt.sourceInformationMarkerStart($composer4, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    int i4 = ((0 >> 6) & 112) | 6;
                                    ComposerKt.sourceInformationMarkerStart($composer4, 1656167412, "C1309@54344L379:DatePicker.kt#uh7d8r");
                                    int i5 = i2 << 3;
                                    int i6 = i2 << 6;
                                    DatePickerKt.Month(month, function15, calendarDate2, stateData3, false, function16, datePickerFormatter2, datePickerColors2, $composer4, (i5 & 458752) | (i5 & 112) | 24576 | (i6 & 7168) | (3670016 & (i2 << 9)) | (29360128 & i6));
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
                };
                $composer3.updateRememberedValue(value$iv$iv3);
            } else {
                $dirty = $dirty3;
            }
            $composer3.endReplaceableGroup();
            $composer2 = $composer3;
            LazyDslKt.LazyRow(semantics$default, lazyListState, null, false, null, null, rememberSnapFlingBehavior$material3_release, false, (Function1) value$iv$iv3, $composer2, ($dirty >> 3) & 112, 188);
            int i = (($dirty >> 6) & 14) | ($dirty & 112);
            $composer2.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv2 = $composer2.changed(lazyListState) | $composer2.changed(stateData);
            Object it$iv$iv = $composer2.rememberedValue();
            if (invalid$iv$iv2 || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new DatePickerKt$HorizontalMonthsList$3$1(lazyListState, stateData, null);
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            EffectsKt.LaunchedEffect(lazyListState, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv$iv, $composer2, (($dirty >> 6) & 14) | 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$4
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
                DatePickerKt.HorizontalMonthsList(function1, stateData, lazyListState, dateFormatter, function12, colors, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    public static final Object updateDisplayedMonth(final LazyListState lazyListState, final StateData stateData, Continuation<? super Unit> continuation) {
        Object collect = SnapshotStateKt.snapshotFlow(new Function0<Integer>() { // from class: androidx.compose.material3.DatePickerKt$updateDisplayedMonth$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(LazyListState.this.getFirstVisibleItemIndex());
            }
        }).collect(new FlowCollector<Integer>() { // from class: androidx.compose.material3.DatePickerKt$updateDisplayedMonth$3
            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Integer num, Continuation $completion) {
                return emit(num.intValue(), (Continuation<? super Unit>) $completion);
            }

            public final Object emit(int it, Continuation<? super Unit> continuation2) {
                int yearOffset = LazyListState.this.getFirstVisibleItemIndex() / 12;
                int month = (LazyListState.this.getFirstVisibleItemIndex() % 12) + 1;
                StateData $this$emit_u24lambda_u240 = stateData;
                if ($this$emit_u24lambda_u240.getDisplayedMonth().getMonth() != month || $this$emit_u24lambda_u240.getDisplayedMonth().getYear() != $this$emit_u24lambda_u240.getYearRange().getFirst() + yearOffset) {
                    $this$emit_u24lambda_u240.setDisplayedMonth($this$emit_u24lambda_u240.getCalendarModel().getMonth($this$emit_u24lambda_u240.getYearRange().getFirst() + yearOffset, month));
                }
                return Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    public static final void WeekDays(final DatePickerColors colors, final CalendarModel calendarModel, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        Intrinsics.checkNotNullParameter(calendarModel, "calendarModel");
        Composer $composer2 = $composer.startRestartGroup(-1849465391);
        ComposerKt.sourceInformation($composer2, "C(WeekDays)P(1)1365@56132L1363:DatePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(colors) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(calendarModel) ? 32 : 16;
        }
        if (($dirty & 91) != 18 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1849465391, $changed, -1, "androidx.compose.material3.WeekDays (DatePicker.kt:1354)");
            }
            int firstDayOfWeek = calendarModel.getFirstDayOfWeek();
            List weekdays = calendarModel.getWeekdayNames();
            final ArrayList dayNames = new ArrayList();
            int size = weekdays.size();
            for (int i = firstDayOfWeek - 1; i < size; i++) {
                dayNames.add(weekdays.get(i));
            }
            int i2 = firstDayOfWeek - 1;
            for (int i3 = 0; i3 < i2; i3++) {
                dayNames.add(weekdays.get(i3));
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2939boximpl(colors.getWeekdayContentColor()))}, ComposableLambdaKt.composableLambda($composer2, -1445541615, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$WeekDays$1
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
                    ComposerKt.sourceInformation($composer3, "C1367@56264L10,1368@56338L1151:DatePicker.kt#uh7d8r");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1445541615, $changed2, -1, "androidx.compose.material3.WeekDays.<anonymous> (DatePicker.kt:1365)");
                        }
                        TextStyle textStyle = TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer3, 6), DatePickerModalTokens.INSTANCE.getWeekdaysLabelTextFont());
                        final ArrayList<Pair<String, String>> arrayList = dayNames;
                        TextKt.ProvideTextStyle(textStyle, ComposableLambdaKt.composableLambda($composer3, 2133710592, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$WeekDays$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Removed duplicated region for block: B:27:0x02bf  */
                            /* JADX WARN: Removed duplicated region for block: B:30:0x02cb  */
                            /* JADX WARN: Removed duplicated region for block: B:33:0x02d1  */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct add '--show-bad-code' argument
                            */
                            public final void invoke(androidx.compose.runtime.Composer r85, int r86) {
                                /*
                                    Method dump skipped, instructions count: 1027
                                    To view this dump add '--comments-level debug' option
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt$WeekDays$1.AnonymousClass1.invoke(androidx.compose.runtime.Composer, int):void");
                            }
                        }), $composer3, 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, 56);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$WeekDays$2
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

            public final void invoke(Composer composer, int i4) {
                DatePickerKt.WeekDays(DatePickerColors.this, calendarModel, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Month(final androidx.compose.material3.CalendarMonth r21, final kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> r22, final androidx.compose.material3.CalendarDate r23, final androidx.compose.material3.StateData r24, final boolean r25, final kotlin.jvm.functions.Function1<? super java.lang.Long, java.lang.Boolean> r26, final androidx.compose.material3.DatePickerFormatter r27, final androidx.compose.material3.DatePickerColors r28, androidx.compose.runtime.Composer r29, final int r30) {
        /*
            Method dump skipped, instructions count: 567
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt.Month(androidx.compose.material3.CalendarMonth, kotlin.jvm.functions.Function1, androidx.compose.material3.CalendarDate, androidx.compose.material3.StateData, boolean, kotlin.jvm.functions.Function1, androidx.compose.material3.DatePickerFormatter, androidx.compose.material3.DatePickerColors, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String dayContentDescription(boolean rangeSelectionEnabled, boolean isToday, boolean isStartDate, boolean isEndDate, boolean isInRange, Composer $composer, int $changed) {
        $composer.startReplaceableGroup(502032503);
        ComposerKt.sourceInformation($composer, "C(dayContentDescription)P(4,3,2)1563@64712L54:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(502032503, $changed, -1, "androidx.compose.material3.dayContentDescription (DatePicker.kt:1538)");
        }
        StringBuilder descriptionBuilder = new StringBuilder();
        $composer.startReplaceableGroup(-852204210);
        ComposerKt.sourceInformation($composer, "");
        if (rangeSelectionEnabled) {
            if (isStartDate) {
                $composer.startReplaceableGroup(-852204120);
                ComposerKt.sourceInformation($composer, "1549@64220L56");
                descriptionBuilder.append(Strings_androidKt.m1785getStringNWtq28(Strings.INSTANCE.m1758getDateRangePickerStartHeadlineadMyvUU(), $composer, 6));
                $composer.endReplaceableGroup();
            } else if (isEndDate) {
                $composer.startReplaceableGroup(-852203980);
                ComposerKt.sourceInformation($composer, "1553@64360L54");
                descriptionBuilder.append(Strings_androidKt.m1785getStringNWtq28(Strings.INSTANCE.m1755getDateRangePickerEndHeadlineadMyvUU(), $composer, 6));
                $composer.endReplaceableGroup();
            } else if (isInRange) {
                $composer.startReplaceableGroup(-852203842);
                ComposerKt.sourceInformation($composer, "1557@64498L53");
                descriptionBuilder.append(Strings_androidKt.m1785getStringNWtq28(Strings.INSTANCE.m1754getDateRangePickerDayInRangeadMyvUU(), $composer, 6));
                $composer.endReplaceableGroup();
            } else {
                $composer.startReplaceableGroup(-852203741);
                $composer.endReplaceableGroup();
            }
        }
        $composer.endReplaceableGroup();
        if (isToday) {
            if (descriptionBuilder.length() > 0) {
                descriptionBuilder.append(", ");
            }
            descriptionBuilder.append(Strings_androidKt.m1785getStringNWtq28(Strings.INSTANCE.m1750getDatePickerTodayDescriptionadMyvUU(), $composer, 6));
        }
        String sb = descriptionBuilder.length() == 0 ? null : descriptionBuilder.toString();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return sb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0245  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Day(final androidx.compose.ui.Modifier r27, final boolean r28, final kotlin.jvm.functions.Function0<kotlin.Unit> r29, final boolean r30, final boolean r31, final boolean r32, final boolean r33, final java.lang.String r34, final androidx.compose.material3.DatePickerColors r35, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, final int r38) {
        /*
            Method dump skipped, instructions count: 625
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt.Day(androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function0, boolean, boolean, boolean, boolean, java.lang.String, androidx.compose.material3.DatePickerColors, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void YearPicker(final Modifier modifier, final Function1<? super Integer, Unit> function1, final DatePickerColors colors, final StateData stateData, Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-1038904873);
        ComposerKt.sourceInformation($composer2, "C(YearPicker)P(1,2)1635@66923L10,1634@66875L4042:DatePicker.kt#uh7d8r");
        int $dirty = $changed;
        if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty |= $composer2.changed(colors) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty |= $composer2.changed(stateData) ? 2048 : 1024;
        }
        if (($dirty & 5851) != 1170 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1038904873, $dirty, -1, "androidx.compose.material3.YearPicker (DatePicker.kt:1628)");
            }
            final int i = $dirty;
            TextKt.ProvideTextStyle(TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography($composer2, 6), DatePickerModalTokens.INSTANCE.getSelectionYearLabelTextFont()), ComposableLambdaKt.composableLambda($composer2, -145469688, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1
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
                    long containerColor;
                    Object value$iv$iv$iv;
                    float f;
                    ComposerKt.sourceInformation($composer3, "C1640@67154L329,1648@67656L11,1653@67868L24,1654@67933L53,1655@68025L51,1656@68085L2826:DatePicker.kt#uh7d8r");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-145469688, $changed2, -1, "androidx.compose.material3.YearPicker.<anonymous> (DatePicker.kt:1636)");
                        }
                        final int currentYear = StateData.this.getCurrentMonth().getYear();
                        final int displayedYear = StateData.this.getDisplayedMonth().getYear();
                        final LazyGridState lazyGridState = LazyGridStateKt.rememberLazyGridState(Integer.max(0, (displayedYear - StateData.this.getYearRange().getFirst()) - 3), 0, $composer3, 0, 2);
                        $composer3.startReplaceableGroup(-969349200);
                        ComposerKt.sourceInformation($composer3, "1649@67705L11,1649@67769L7");
                        if (Color.m2950equalsimpl0(colors.getContainerColor(), MaterialTheme.INSTANCE.getColorScheme($composer3, 6).m1378getSurface0d7_KjU())) {
                            ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme($composer3, 6);
                            ProvidableCompositionLocal<Dp> localAbsoluteTonalElevation = SurfaceKt.getLocalAbsoluteTonalElevation();
                            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            Object consume = $composer3.consume(localAbsoluteTonalElevation);
                            ComposerKt.sourceInformationMarkerEnd($composer3);
                            containerColor = ColorSchemeKt.m1419surfaceColorAtElevation3ABfNKs(colorScheme, ((Dp) consume).m5232unboximpl());
                        } else {
                            containerColor = colors.getContainerColor();
                        }
                        $composer3.endReplaceableGroup();
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
                        final String scrollToEarlierYearsLabel = Strings_androidKt.m1785getStringNWtq28(Strings.INSTANCE.m1741getDatePickerScrollToShowEarlierYearsadMyvUU(), $composer3, 6);
                        final String scrollToLaterYearsLabel = Strings_androidKt.m1785getStringNWtq28(Strings.INSTANCE.m1742getDatePickerScrollToShowLaterYearsadMyvUU(), $composer3, 6);
                        GridCells.Fixed fixed = new GridCells.Fixed(3);
                        Modifier semantics$default = SemanticsModifierKt.semantics$default(BackgroundKt.m163backgroundbw27NRU$default(modifier, containerColor, null, 2, null), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semantics) {
                                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                SemanticsPropertiesKt.setVerticalScrollAxisRange(semantics, new ScrollAxisRange(new Function0<Float>() { // from class: androidx.compose.material3.DatePickerKt.YearPicker.1.1.1
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Float invoke() {
                                        return Float.valueOf(0.0f);
                                    }
                                }, new Function0<Float>() { // from class: androidx.compose.material3.DatePickerKt.YearPicker.1.1.2
                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Float invoke() {
                                        return Float.valueOf(0.0f);
                                    }
                                }, false, 4, null));
                            }
                        }, 1, null);
                        Arrangement.HorizontalOrVertical spaceEvenly = Arrangement.INSTANCE.getSpaceEvenly();
                        Arrangement arrangement = Arrangement.INSTANCE;
                        f = DatePickerKt.YearsVerticalPadding;
                        final StateData stateData2 = StateData.this;
                        final Function1<Integer, Unit> function12 = function1;
                        final int i2 = i;
                        final DatePickerColors datePickerColors = colors;
                        LazyGridDslKt.LazyVerticalGrid(fixed, semantics$default, lazyGridState, null, false, arrangement.m395spacedBy0680j_4(f), spaceEvenly, null, false, new Function1<LazyGridScope, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(LazyGridScope lazyGridScope) {
                                invoke2(lazyGridScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(LazyGridScope LazyVerticalGrid) {
                                Intrinsics.checkNotNullParameter(LazyVerticalGrid, "$this$LazyVerticalGrid");
                                int count = CollectionsKt.count(StateData.this.getYearRange());
                                final StateData stateData3 = StateData.this;
                                final int i3 = displayedYear;
                                final int i4 = currentYear;
                                final Function1<Integer, Unit> function13 = function12;
                                final int i5 = i2;
                                final DatePickerColors datePickerColors2 = datePickerColors;
                                final LazyGridState lazyGridState2 = lazyGridState;
                                final CoroutineScope coroutineScope2 = coroutineScope;
                                final String str = scrollToEarlierYearsLabel;
                                final String str2 = scrollToLaterYearsLabel;
                                LazyGridScope.items$default(LazyVerticalGrid, count, null, null, null, ComposableLambdaKt.composableLambdaInstance(1369226173, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt.YearPicker.1.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(4);
                                    }

                                    @Override // kotlin.jvm.functions.Function4
                                    public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
                                        invoke(lazyGridItemScope, num.intValue(), composer, num2.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX WARN: Removed duplicated region for block: B:31:0x013b  */
                                    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                        To view partially-correct add '--show-bad-code' argument
                                    */
                                    public final void invoke(androidx.compose.foundation.lazy.grid.LazyGridItemScope r24, final int r25, androidx.compose.runtime.Composer r26, int r27) {
                                        /*
                                            Method dump skipped, instructions count: 319
                                            To view this dump add '--comments-level debug' option
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt$YearPicker$1.AnonymousClass2.AnonymousClass1.invoke(androidx.compose.foundation.lazy.grid.LazyGridItemScope, int, androidx.compose.runtime.Composer, int):void");
                                    }
                                }), 14, null);
                            }
                        }, $composer3, 1769472, 408);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, 48);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPicker$2
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
                DatePickerKt.YearPicker(Modifier.this, function1, colors, stateData, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Year(final androidx.compose.ui.Modifier r28, final boolean r29, final boolean r30, final kotlin.jvm.functions.Function0<kotlin.Unit> r31, final java.lang.String r32, final androidx.compose.material3.DatePickerColors r33, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r34, androidx.compose.runtime.Composer r35, final int r36) {
        /*
            Method dump skipped, instructions count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DatePickerKt.Year(androidx.compose.ui.Modifier, boolean, boolean, kotlin.jvm.functions.Function0, java.lang.String, androidx.compose.material3.DatePickerColors, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MonthsNavigation(final Modifier modifier, final boolean nextAvailable, final boolean previousAvailable, final boolean yearPickerVisible, final String yearPickerText, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> function03, Composer $composer, final int $changed) {
        Arrangement.HorizontalOrVertical spaceBetween;
        Function0 factory$iv$iv$iv;
        int $dirty;
        Composer $composer2 = $composer.startRestartGroup(-1127095896);
        ComposerKt.sourceInformation($composer2, "C(MonthsNavigation)P(!2,5,7,6)1775@72887L2078:DatePicker.kt#uh7d8r");
        int $dirty2 = $changed;
        if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($changed & 112) == 0) {
            $dirty2 |= $composer2.changed(nextAvailable) ? 32 : 16;
        }
        if (($changed & 896) == 0) {
            $dirty2 |= $composer2.changed(previousAvailable) ? 256 : 128;
        }
        if (($changed & 7168) == 0) {
            $dirty2 |= $composer2.changed(yearPickerVisible) ? 2048 : 1024;
        }
        if ((57344 & $changed) == 0) {
            $dirty2 |= $composer2.changed(yearPickerText) ? 16384 : 8192;
        }
        if ((458752 & $changed) == 0) {
            $dirty2 |= $composer2.changedInstance(function0) ? 131072 : 65536;
        }
        if ((3670016 & $changed) == 0) {
            $dirty2 |= $composer2.changedInstance(function02) ? 1048576 : 524288;
        }
        if ((29360128 & $changed) == 0) {
            $dirty2 |= $composer2.changedInstance(function03) ? 8388608 : 4194304;
        }
        final int $dirty3 = $dirty2;
        if ((23967451 & $dirty3) != 4793490 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1127095896, $dirty3, -1, "androidx.compose.material3.MonthsNavigation (DatePicker.kt:1765)");
            }
            Modifier modifier$iv = SizeKt.m520requiredHeight3ABfNKs(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), MonthYearHeight);
            if (yearPickerVisible) {
                spaceBetween = Arrangement.INSTANCE.getStart();
            } else {
                spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            }
            Alignment.Vertical verticalAlignment$iv = Alignment.INSTANCE.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = spaceBetween;
            $composer2.startReplaceableGroup(693286680);
            ComposerKt.sourceInformation($composer2, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
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
            Function0 factory$iv$iv$iv2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3 skippableUpdate$iv$iv$iv = LayoutKt.materializerOf(modifier$iv);
            int $changed$iv$iv$iv = (($changed$iv$iv << 9) & 7168) | 6;
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
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
            int i = ($changed$iv$iv$iv >> 9) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, -326682283, "C80@4021L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int i2 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1911928903, "C1787@73264L536:DatePicker.kt#uh7d8r");
            YearPickerMenuButton(function03, yearPickerVisible, null, ComposableLambdaKt.composableLambda($composer2, -1156508456, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$MonthsNavigation$1$1
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
                    Object value$iv$iv;
                    ComposerKt.sourceInformation($composer3, "C1792@73474L315,1791@73400L390:DatePicker.kt#uh7d8r");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1156508456, $changed2, -1, "androidx.compose.material3.MonthsNavigation.<anonymous>.<anonymous> (DatePicker.kt:1790)");
                        }
                        String str = yearPickerText;
                        Modifier.Companion companion = Modifier.INSTANCE;
                        Object key1$iv = yearPickerText;
                        final String str2 = yearPickerText;
                        int i3 = ($dirty3 >> 12) & 14;
                        $composer3.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation($composer3, "CC(remember)P(1):Composables.kt#9igjgp");
                        boolean invalid$iv$iv = $composer3.changed(key1$iv);
                        Object it$iv$iv = $composer3.rememberedValue();
                        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                            value$iv$iv = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DatePickerKt$MonthsNavigation$1$1$1$1
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
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                    SemanticsPropertiesKt.m4581setLiveRegionhR3wRGc(semantics, LiveRegionMode.INSTANCE.m4560getPolite0phEisY());
                                    SemanticsPropertiesKt.setContentDescription(semantics, str2);
                                }
                            };
                            $composer3.updateRememberedValue(value$iv$iv);
                        } else {
                            value$iv$iv = it$iv$iv;
                        }
                        $composer3.endReplaceableGroup();
                        TextKt.m1872Text4IGK_g(str, SemanticsModifierKt.semantics$default(companion, false, (Function1) value$iv$iv, 1, null), 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, ($dirty3 >> 12) & 14, 0, 131068);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, (($dirty3 >> 21) & 14) | 3072 | (($dirty3 >> 6) & 112), 4);
            $composer2.startReplaceableGroup(979007906);
            ComposerKt.sourceInformation($composer2, "1801@73938L1011");
            if (yearPickerVisible) {
                $dirty = $dirty3;
            } else {
                $composer2.startReplaceableGroup(693286680);
                ComposerKt.sourceInformation($composer2, "CC(Row)P(2,1,3)78@3913L58,79@3976L130:Row.kt#2w3rfo");
                Modifier modifier$iv2 = Modifier.INSTANCE;
                Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.getStart();
                Alignment.Vertical verticalAlignment$iv2 = Alignment.INSTANCE.getTop();
                MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                int $changed$iv$iv2 = (0 << 3) & 112;
                $composer2.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume4 = $composer2.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                Density density$iv$iv2 = (Density) consume4;
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection2 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume5 = $composer2.consume(localLayoutDirection2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                LayoutDirection layoutDirection$iv$iv2 = (LayoutDirection) consume5;
                ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration2 = CompositionLocalsKt.getLocalViewConfiguration();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume6 = $composer2.consume(localViewConfiguration2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ViewConfiguration viewConfiguration$iv$iv2 = (ViewConfiguration) consume6;
                Function0 factory$iv$iv$iv3 = ComposeUiNode.INSTANCE.getConstructor();
                Function3 skippableUpdate$iv$iv$iv2 = LayoutKt.materializerOf(modifier$iv2);
                int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 9) & 7168) | 6;
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    $composer2.createNode(factory$iv$iv$iv3);
                } else {
                    $composer2.useNode();
                }
                $composer2.disableReusing();
                Composer $this$Layout_u24lambda_u2d0$iv$iv2 = Updater.m2583constructorimpl($composer2);
                Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, measurePolicy$iv2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, density$iv$iv2, ComposeUiNode.INSTANCE.getSetDensity());
                Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, layoutDirection$iv$iv2, ComposeUiNode.INSTANCE.getSetLayoutDirection());
                Updater.m2590setimpl($this$Layout_u24lambda_u2d0$iv$iv2, viewConfiguration$iv$iv2, ComposeUiNode.INSTANCE.getSetViewConfiguration());
                $composer2.enableReusing();
                skippableUpdate$iv$iv$iv2.invoke(SkippableUpdater.m2574boximpl(SkippableUpdater.m2575constructorimpl($composer2)), $composer2, Integer.valueOf(($changed$iv$iv$iv2 >> 3) & 112));
                $composer2.startReplaceableGroup(2058660585);
                int i3 = ($changed$iv$iv$iv2 >> 9) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, -326682283, "C80@4021L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                int i4 = ((0 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 479941280, "C1802@73991L7,1803@74038L446,1813@74501L434:DatePicker.kt#uh7d8r");
                ProvidableCompositionLocal<LayoutDirection> localLayoutDirection3 = CompositionLocalsKt.getLocalLayoutDirection();
                ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume7 = $composer2.consume(localLayoutDirection3);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                final boolean rtl = consume7 == LayoutDirection.Rtl;
                $dirty = $dirty3;
                IconButtonKt.IconButton(function02, null, previousAvailable, null, null, ComposableLambdaKt.composableLambda($composer2, -1143715416, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$MonthsNavigation$1$2$1
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
                        ImageVector keyboardArrowLeft;
                        ComposerKt.sourceInformation($composer3, "C1810@74394L50,1804@74129L337:DatePicker.kt#uh7d8r");
                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1143715416, $changed2, -1, "androidx.compose.material3.MonthsNavigation.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1803)");
                            }
                            if (rtl) {
                                keyboardArrowLeft = KeyboardArrowRightKt.getKeyboardArrowRight(Icons.Filled.INSTANCE);
                            } else {
                                keyboardArrowLeft = KeyboardArrowLeftKt.getKeyboardArrowLeft(Icons.Filled.INSTANCE);
                            }
                            IconKt.m1556Iconww6aTOc(keyboardArrowLeft, Strings_androidKt.m1785getStringNWtq28(Strings.INSTANCE.m1747getDatePickerSwitchToPreviousMonthadMyvUU(), $composer3, 6), (Modifier) null, 0L, $composer3, 0, 12);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }), $composer2, (($dirty >> 18) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ($dirty & 896), 26);
                IconButtonKt.IconButton(function0, null, nextAvailable, null, null, ComposableLambdaKt.composableLambda($composer2, 1336532191, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$MonthsNavigation$1$2$2
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
                        ImageVector keyboardArrowRight;
                        ComposerKt.sourceInformation($composer3, "C1820@74849L46,1814@74584L333:DatePicker.kt#uh7d8r");
                        if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1336532191, $changed2, -1, "androidx.compose.material3.MonthsNavigation.<anonymous>.<anonymous>.<anonymous> (DatePicker.kt:1813)");
                            }
                            if (rtl) {
                                keyboardArrowRight = KeyboardArrowLeftKt.getKeyboardArrowLeft(Icons.Filled.INSTANCE);
                            } else {
                                keyboardArrowRight = KeyboardArrowRightKt.getKeyboardArrowRight(Icons.Filled.INSTANCE);
                            }
                            IconKt.m1556Iconww6aTOc(keyboardArrowRight, Strings_androidKt.m1785getStringNWtq28(Strings.INSTANCE.m1746getDatePickerSwitchToNextMonthadMyvUU(), $composer3, 6), (Modifier) null, 0L, $composer3, 0, 12);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        $composer3.skipToGroupEnd();
                    }
                }), $composer2, (($dirty >> 15) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | (($dirty << 3) & 896), 26);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endReplaceableGroup();
                $composer2.endNode();
                $composer2.endReplaceableGroup();
                $composer2.endReplaceableGroup();
            }
            $composer2.endReplaceableGroup();
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
            $dirty = $dirty3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$MonthsNavigation$2
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

            public final void invoke(Composer composer, int i5) {
                DatePickerKt.MonthsNavigation(Modifier.this, nextAvailable, previousAvailable, yearPickerVisible, yearPickerText, function0, function02, function03, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void YearPickerMenuButton(final Function0<Unit> function0, final boolean expanded, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Composer $composer2 = $composer.startRestartGroup(409654418);
        ComposerKt.sourceInformation($composer2, "C(YearPickerMenuButton)P(3,1,2)1841@75389L11,1841@75343L75,1836@75206L690:DatePicker.kt#uh7d8r");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer2.changed(expanded) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 2048 : 1024;
        }
        final int $dirty2 = $dirty;
        if (($dirty2 & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier.Companion modifier4 = i2 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(409654418, $dirty2, -1, "androidx.compose.material3.YearPickerMenuButton (DatePicker.kt:1830)");
            }
            ButtonKt.TextButton(function0, modifier4, false, RoundedCornerShapeKt.getCircleShape(), ButtonDefaults.INSTANCE.m1333textButtonColorsro_MJ88(0L, MaterialTheme.INSTANCE.getColorScheme($composer2, 6).m1368getOnSurfaceVariant0d7_KjU(), 0L, 0L, $composer2, 24576, 13), null, null, null, null, ComposableLambdaKt.composableLambda($composer2, 1899012021, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPickerMenuButton$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                    invoke(rowScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope TextButton, Composer $composer3, int $changed2) {
                    String str;
                    Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                    ComposerKt.sourceInformation($composer3, "C1845@75485L9,1846@75503L49,1847@75561L329:DatePicker.kt#uh7d8r");
                    if (($changed2 & 81) != 16 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1899012021, $changed2, -1, "androidx.compose.material3.YearPickerMenuButton.<anonymous> (DatePicker.kt:1844)");
                        }
                        function2.invoke($composer3, Integer.valueOf(($dirty2 >> 9) & 14));
                        SpacerKt.Spacer(SizeKt.m531size3ABfNKs(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m1329getIconSpacingD9Ej5fM()), $composer3, 6);
                        ImageVector arrowDropDown = ArrowDropDownKt.getArrowDropDown(Icons.Filled.INSTANCE);
                        if (expanded) {
                            $composer3.startReplaceableGroup(1071182504);
                            ComposerKt.sourceInformation($composer3, "1850@75672L49");
                            String m1785getStringNWtq28 = Strings_androidKt.m1785getStringNWtq28(Strings.INSTANCE.m1744getDatePickerSwitchToDaySelectionadMyvUU(), $composer3, 6);
                            $composer3.endReplaceableGroup();
                            str = m1785getStringNWtq28;
                        } else {
                            $composer3.startReplaceableGroup(1071182591);
                            ComposerKt.sourceInformation($composer3, "1852@75759L50");
                            String m1785getStringNWtq282 = Strings_androidKt.m1785getStringNWtq28(Strings.INSTANCE.m1748getDatePickerSwitchToYearSelectionadMyvUU(), $composer3, 6);
                            $composer3.endReplaceableGroup();
                            str = m1785getStringNWtq282;
                        }
                        IconKt.m1556Iconww6aTOc(arrowDropDown, str, RotateKt.rotate(Modifier.INSTANCE, expanded ? 180.0f : 0.0f), 0L, $composer3, 0, 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, 807075840 | ($dirty2 & 14) | (($dirty2 >> 3) & 112), 388);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier5 = modifier3;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DatePickerKt$YearPickerMenuButton$2
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

            public final void invoke(Composer composer, int i3) {
                DatePickerKt.YearPickerMenuButton(function0, expanded, modifier5, function2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<CustomAccessibilityAction> customScrollActions(final LazyGridState state, final CoroutineScope coroutineScope, String scrollUpLabel, String scrollDownLabel) {
        Function0 scrollUpAction = new Function0<Boolean>() { // from class: androidx.compose.material3.DatePickerKt$customScrollActions$scrollUpAction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z;
                if (LazyGridState.this.getCanScrollBackward()) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(LazyGridState.this, null), 3, null);
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: DatePicker.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(c = "androidx.compose.material3.DatePickerKt$customScrollActions$scrollUpAction$1$1", f = "DatePicker.kt", i = {}, l = {1871}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.DatePickerKt$customScrollActions$scrollUpAction$1$1, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ LazyGridState $state;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(LazyGridState lazyGridState, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$state = lazyGridState;
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
                            if (LazyGridState.scrollToItem$default(this.$state, this.$state.getFirstVisibleItemIndex() - 3, 0, this, 2, null) != coroutine_suspended) {
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
        Function0 scrollDownAction = new Function0<Boolean>() { // from class: androidx.compose.material3.DatePickerKt$customScrollActions$scrollDownAction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z;
                if (LazyGridState.this.getCanScrollForward()) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass1(LazyGridState.this, null), 3, null);
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: DatePicker.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(c = "androidx.compose.material3.DatePickerKt$customScrollActions$scrollDownAction$1$1", f = "DatePicker.kt", i = {}, l = {1881}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.DatePickerKt$customScrollActions$scrollDownAction$1$1, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ LazyGridState $state;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(LazyGridState lazyGridState, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$state = lazyGridState;
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
                            if (LazyGridState.scrollToItem$default(this.$state, this.$state.getFirstVisibleItemIndex() + 3, 0, this, 2, null) != coroutine_suspended) {
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

    public static final String toLocalString(int $this$toLocalString) {
        NumberFormat formatter = NumberFormat.getIntegerInstance();
        formatter.setGroupingUsed(false);
        String format = formatter.format(Integer.valueOf($this$toLocalString));
        Intrinsics.checkNotNullExpressionValue(format, "formatter.format(this)");
        return format;
    }

    public static final float getRecommendedSizeForAccessibility() {
        return RecommendedSizeForAccessibility;
    }

    public static final float getMonthYearHeight() {
        return MonthYearHeight;
    }

    public static final float getDatePickerHorizontalPadding() {
        return DatePickerHorizontalPadding;
    }

    public static final PaddingValues getDatePickerModeTogglePadding() {
        return DatePickerModeTogglePadding;
    }
}
