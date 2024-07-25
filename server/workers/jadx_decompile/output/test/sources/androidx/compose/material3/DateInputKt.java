package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DateInput.kt */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a1\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0001¢\u0006\u0002\u0010\u0011\u001a\u008f\u0001\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0014\u0010\u001b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\b0\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"InputTextFieldPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getInputTextFieldPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "InputTextNonErroneousBottomPadding", "Landroidx/compose/ui/unit/Dp;", "F", "DateInputContent", "", "stateData", "Landroidx/compose/material3/StateData;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "dateValidator", "Lkotlin/Function1;", "", "", "(Landroidx/compose/material3/StateData;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "DateInputTextField", "modifier", "Landroidx/compose/ui/Modifier;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "initialDate", "Landroidx/compose/material3/CalendarDate;", "onDateChanged", "inputIdentifier", "Landroidx/compose/material3/InputIdentifier;", "dateInputValidator", "Landroidx/compose/material3/DateInputValidator;", "dateInputFormat", "Landroidx/compose/material3/DateInputFormat;", "locale", "Ljava/util/Locale;", "DateInputTextField-zm97o8M", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/StateData;Landroidx/compose/material3/CalendarDate;Lkotlin/jvm/functions/Function1;ILandroidx/compose/material3/DateInputValidator;Landroidx/compose/material3/DateInputFormat;Ljava/util/Locale;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DateInputKt {
    private static final PaddingValues InputTextFieldPadding = PaddingKt.m481PaddingValuesa9UjIt4$default(Dp.m5218constructorimpl(24), Dp.m5218constructorimpl(10), Dp.m5218constructorimpl(24), 0.0f, 8, null);
    private static final float InputTextNonErroneousBottomPadding = Dp.m5218constructorimpl(16);

    /* JADX WARN: Removed duplicated region for block: B:54:0x021a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void DateInputContent(final androidx.compose.material3.StateData r31, final androidx.compose.material3.DatePickerFormatter r32, final kotlin.jvm.functions.Function1<? super java.lang.Long, java.lang.Boolean> r33, androidx.compose.runtime.Composer r34, final int r35) {
        /*
            Method dump skipped, instructions count: 563
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.DateInputKt.DateInputContent(androidx.compose.material3.StateData, androidx.compose.material3.DatePickerFormatter, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    /* renamed from: DateInputTextField-zm97o8M, reason: not valid java name */
    public static final void m1452DateInputTextFieldzm97o8M(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final StateData stateData, final CalendarDate initialDate, final Function1<? super CalendarDate, Unit> onDateChanged, final int inputIdentifier, final DateInputValidator dateInputValidator, final DateInputFormat dateInputFormat, final Locale locale, Composer $composer, final int $changed) {
        float f;
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(stateData, "stateData");
        Intrinsics.checkNotNullParameter(onDateChanged, "onDateChanged");
        Intrinsics.checkNotNullParameter(dateInputValidator, "dateInputValidator");
        Intrinsics.checkNotNullParameter(dateInputFormat, "dateInputFormat");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Composer $composer2 = $composer.startRestartGroup(626552973);
        ComposerKt.sourceInformation($composer2, "C(DateInputTextField)P(6,4,8,9,2,7,3:c#material3.InputIdentifier,1)109@4431L39,110@4487L528,166@6737L88,127@5021L2277:DateInput.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(626552973, $changed, -1, "androidx.compose.material3.DateInputTextField (DateInput.kt:97)");
        }
        final MutableState errorText = (MutableState) RememberSaveableKt.m2596rememberSaveable(new Object[0], (Saver) null, (String) null, (Function0) new Function0<MutableState<String>>() { // from class: androidx.compose.material3.DateInputKt$DateInputTextField$errorText$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MutableState<String> invoke() {
                MutableState<String> mutableStateOf$default;
                mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
                return mutableStateOf$default;
            }
        }, $composer2, 3080, 6);
        final MutableState text$delegate = RememberSaveableKt.rememberSaveable(new Object[0], (Saver) TextFieldValue.INSTANCE.getSaver(), (String) null, (Function0) new Function0<MutableState<TextFieldValue>>() { // from class: androidx.compose.material3.DateInputKt$DateInputTextField$text$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MutableState<TextFieldValue> invoke() {
                MutableState<TextFieldValue> mutableStateOf$default;
                String formatWithPattern;
                StateData $this$invoke_u24lambda_u241 = StateData.this;
                CalendarDate it = initialDate;
                mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue((it == null || (formatWithPattern = $this$invoke_u24lambda_u241.getCalendarModel().formatWithPattern(it.getUtcTimeMillis(), dateInputFormat.getPatternWithoutDelimiters(), locale)) == null) ? "" : formatWithPattern, TextRangeKt.TextRange(0, 0), (TextRange) null, 4, (DefaultConstructorMarker) null), null, 2, null);
                return mutableStateOf$default;
            }
        }, $composer2, 72, 4);
        TextFieldValue DateInputTextField_zm97o8M$lambda$3 = DateInputTextField_zm97o8M$lambda$3(text$delegate);
        Function1<TextFieldValue, Unit> function1 = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.material3.DateInputKt$DateInputTextField$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TextFieldValue textFieldValue) {
                invoke2(textFieldValue);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TextFieldValue input) {
                CharSequence $this$all$iv;
                Intrinsics.checkNotNullParameter(input, "input");
                if (input.getText().length() <= DateInputFormat.this.getPatternWithoutDelimiters().length()) {
                    CharSequence $this$all$iv2 = input.getText();
                    int i = 0;
                    while (true) {
                        if (i < $this$all$iv2.length()) {
                            char element$iv = $this$all$iv2.charAt(i);
                            if (!Character.isDigit(element$iv)) {
                                $this$all$iv = null;
                                break;
                            }
                            i++;
                        } else {
                            $this$all$iv = 1;
                            break;
                        }
                    }
                    if ($this$all$iv == null) {
                        return;
                    }
                    text$delegate.setValue(input);
                    String trimmedText = StringsKt.trim((CharSequence) input.getText()).toString();
                    if ((trimmedText.length() == 0) || trimmedText.length() < DateInputFormat.this.getPatternWithoutDelimiters().length()) {
                        errorText.setValue("");
                        onDateChanged.invoke(null);
                    } else {
                        CalendarDate parsedDate = stateData.getCalendarModel().parse(trimmedText, DateInputFormat.this.getPatternWithoutDelimiters());
                        errorText.setValue(dateInputValidator.m1453validateXivgLIo(parsedDate, inputIdentifier, locale));
                        onDateChanged.invoke(errorText.getValue().length() == 0 ? parsedDate : null);
                    }
                }
            }
        };
        if (!(!StringsKt.isBlank((CharSequence) errorText.getValue()))) {
            f = InputTextNonErroneousBottomPadding;
        } else {
            f = Dp.m5218constructorimpl(0);
        }
        Modifier m488paddingqDBjuR0$default = PaddingKt.m488paddingqDBjuR0$default(modifier, 0.0f, 0.0f, 0.0f, f, 7, null);
        $composer2.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer2.changed(errorText);
        Object it$iv$iv = $composer2.rememberedValue();
        if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.DateInputKt$DateInputTextField$2$1
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
                    if (!StringsKt.isBlank(errorText.getValue())) {
                        SemanticsPropertiesKt.error(semantics, errorText.getValue());
                    }
                }
            };
            $composer2.updateRememberedValue(value$iv$iv);
        } else {
            value$iv$iv = it$iv$iv;
        }
        $composer2.endReplaceableGroup();
        OutlinedTextFieldKt.OutlinedTextField(DateInputTextField_zm97o8M$lambda$3, (Function1<? super TextFieldValue, Unit>) function1, SemanticsModifierKt.semantics$default(m488paddingqDBjuR0$default, false, (Function1) value$iv$iv, 1, null), false, false, (TextStyle) null, function2, function22, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda($composer2, 785795078, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateInputKt$DateInputTextField$3
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
                ComposerKt.sourceInformation($composer3, "C171@6946L21:DateInput.kt#uh7d8r");
                if (($changed2 & 11) == 2 && $composer3.getSkipping()) {
                    $composer3.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(785795078, $changed2, -1, "androidx.compose.material3.DateInputTextField.<anonymous> (DateInput.kt:171)");
                }
                if (!StringsKt.isBlank(errorText.getValue())) {
                    TextKt.m1872Text4IGK_g(errorText.getValue(), (Modifier) null, 0L, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, $composer3, 0, 0, 131070);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), !StringsKt.isBlank((CharSequence) errorText.getValue()), (VisualTransformation) new DateVisualTransformation(dateInputFormat), new KeyboardOptions(0, false, KeyboardType.INSTANCE.m4933getNumberPjHm6EE(), ImeAction.INSTANCE.m4885getDoneeUduSuo(), 1, null), (KeyboardActions) null, true, 0, 0, (MutableInteractionSource) null, (Shape) null, (TextFieldColors) null, $composer2, (($changed << 15) & 3670016) | (29360128 & ($changed << 15)), 12779904, 0, 8195896);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.DateInputKt$DateInputTextField$4
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

            public final void invoke(Composer composer, int i) {
                DateInputKt.m1452DateInputTextFieldzm97o8M(Modifier.this, function2, function22, stateData, initialDate, onDateChanged, inputIdentifier, dateInputValidator, dateInputFormat, locale, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1));
            }
        });
    }

    private static final TextFieldValue DateInputTextField_zm97o8M$lambda$3(MutableState<TextFieldValue> mutableState) {
        MutableState<TextFieldValue> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    public static final PaddingValues getInputTextFieldPadding() {
        return InputTextFieldPadding;
    }
}
