package androidx.compose.material;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldImpl.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aß\u0001\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\f2\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020 0%¢\u0006\u0002\b&2\u0006\u0010'\u001a\u00020(2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020.2\b\b\u0002\u00100\u001a\u00020.2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&H\u0001¢\u0006\u0002\u00108\u001aW\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2 \u0010@\u001a\u001c\u0012\u0004\u0012\u00020 0%¢\u0006\u0002\b&¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\u0003\u0010\u0000H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001a\u0012\u0010E\u001a\u00020\u00012\b\u0010F\u001a\u0004\u0018\u00010GH\u0000\u001a\u0012\u0010H\u001a\u00020\u00012\b\u0010F\u001a\u0004\u0018\u00010GH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0002\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0012\u001a\u00020\u0003X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0013\u0010\u0005\"\u000e\u0010\u0014\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u0019\u0010\u0015\u001a\u00020\u0016X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u001c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006I"}, d2 = {"AnimationDuration", "", "HorizontalIconPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalIconPadding", "()F", "F", "IconDefaultSizeModifier", "Landroidx/compose/ui/Modifier;", "getIconDefaultSizeModifier", "()Landroidx/compose/ui/Modifier;", "LabelId", "", "LeadingId", "PlaceholderAnimationDelayOrDuration", "PlaceholderAnimationDuration", "PlaceholderId", "TextFieldId", "TextFieldPadding", "getTextFieldPadding", "TrailingId", "ZeroConstraints", "Landroidx/compose/ui/unit/Constraints;", "getZeroConstraints", "()J", "J", "layoutId", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "CommonDecorationBox", "", "type", "Landroidx/compose/material/TextFieldType;", "value", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material/TextFieldColors;", OutlinedTextFieldKt.BorderId, "(Landroidx/compose/material/TextFieldType;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "typography", "Landroidx/compose/ui/text/TextStyle;", "contentAlpha", "", "content", "Landroidx/compose/runtime/ComposableOpenTarget;", "index", "Decoration-euL9pac", "(JLandroidx/compose/ui/text/TextStyle;Ljava/lang/Float;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "heightOrZero", "placeable", "Landroidx/compose/ui/layout/Placeable;", "widthOrZero", "material_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TextFieldImplKt {
    public static final int AnimationDuration = 150;
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;
    public static final String PlaceholderId = "Hint";
    public static final String TextFieldId = "TextField";
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);
    private static final float TextFieldPadding = Dp.m5218constructorimpl(16);
    private static final float HorizontalIconPadding = Dp.m5218constructorimpl(12);
    private static final Modifier IconDefaultSizeModifier = SizeKt.m515defaultMinSizeVpY3zN4(Modifier.INSTANCE, Dp.m5218constructorimpl(48), Dp.m5218constructorimpl(48));

    public static final void CommonDecorationBox(final TextFieldType type, final String value, final Function2<? super Composer, ? super Integer, Unit> innerTextField, final VisualTransformation visualTransformation, final Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean singleLine, boolean enabled, boolean isError, final InteractionSource interactionSource, final PaddingValues contentPadding, final TextFieldColors colors, Function2<? super Composer, ? super Integer, Unit> function25, Composer $composer, final int $changed, final int $changed1, final int i) {
        Object value$iv$iv;
        InputPhase inputPhase;
        long j;
        boolean z;
        long j2;
        Composer $composer2;
        Function2 border;
        boolean isError2;
        boolean isError3;
        boolean enabled2;
        Function2 trailingIcon;
        Function2 trailingIcon2;
        Function2 leadingIcon;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
        Intrinsics.checkNotNullParameter(visualTransformation, "visualTransformation");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Composer $composer3 = $composer.startRestartGroup(-712568069);
        ComposerKt.sourceInformation($composer3, "C(CommonDecorationBox)P(12,13,4,14,7,9,8,11,10,3,6,5,2,1)80@3167L105,84@3322L25,101@3932L10,108@4267L5253:TextFieldImpl.kt#jmzs0o");
        int $dirty = $changed;
        int $dirty1 = $changed1;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer3.changed(type) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty |= 48;
        } else if (($changed & 112) == 0) {
            $dirty |= $composer3.changed(value) ? 32 : 16;
        }
        if ((i & 4) != 0) {
            $dirty |= 384;
        } else if (($changed & 896) == 0) {
            $dirty |= $composer3.changedInstance(innerTextField) ? 256 : 128;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer3.changed(visualTransformation) ? 2048 : 1024;
        }
        if ((i & 16) != 0) {
            $dirty |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty |= $composer3.changedInstance(function2) ? 16384 : 8192;
        }
        int i2 = i & 32;
        if (i2 != 0) {
            $dirty |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if (($changed & 458752) == 0) {
            $dirty |= $composer3.changedInstance(function22) ? 131072 : 65536;
        }
        int i3 = i & 64;
        if (i3 != 0) {
            $dirty |= 1572864;
        } else if (($changed & 3670016) == 0) {
            $dirty |= $composer3.changedInstance(function23) ? 1048576 : 524288;
        }
        int i4 = i & 128;
        if (i4 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer3.changedInstance(function24) ? 8388608 : 4194304;
        }
        int i5 = i & 256;
        if (i5 != 0) {
            $dirty |= 100663296;
        } else if (($changed & 234881024) == 0) {
            $dirty |= $composer3.changed(singleLine) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i6 = i & 512;
        if (i6 != 0) {
            $dirty |= 805306368;
        } else if (($changed & 1879048192) == 0) {
            $dirty |= $composer3.changed(enabled) ? 536870912 : 268435456;
        }
        int i7 = i & 1024;
        if (i7 != 0) {
            $dirty1 |= 6;
        } else if (($changed1 & 14) == 0) {
            $dirty1 |= $composer3.changed(isError) ? 4 : 2;
        }
        if ((i & 2048) != 0) {
            $dirty1 |= 48;
        } else if (($changed1 & 112) == 0) {
            $dirty1 |= $composer3.changed(interactionSource) ? 32 : 16;
        }
        if ((i & 4096) != 0) {
            $dirty1 |= 384;
        } else if (($changed1 & 896) == 0) {
            $dirty1 |= $composer3.changed(contentPadding) ? 256 : 128;
        }
        if ((i & 8192) != 0) {
            $dirty1 |= 3072;
        } else if (($changed1 & 7168) == 0) {
            $dirty1 |= $composer3.changed(colors) ? 2048 : 1024;
        }
        int i8 = i & 16384;
        if (i8 != 0) {
            $dirty1 |= 24576;
        } else if (($changed1 & 57344) == 0) {
            $dirty1 |= $composer3.changedInstance(function25) ? 16384 : 8192;
        }
        if (($dirty & 1533916891) == 306783378 && (46811 & $dirty1) == 9362 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            leadingIcon = function22;
            trailingIcon2 = function23;
            trailingIcon = function24;
            enabled2 = singleLine;
            isError3 = enabled;
            isError2 = isError;
            border = function25;
            $composer2 = $composer3;
        } else {
            Function2 placeholder = i2 != 0 ? null : function22;
            Function2 leadingIcon2 = i3 != 0 ? null : function23;
            Function2 trailingIcon3 = i4 != 0 ? null : function24;
            boolean singleLine2 = i5 != 0 ? false : singleLine;
            boolean enabled3 = i6 != 0 ? true : enabled;
            boolean isError4 = i7 != 0 ? false : isError;
            Function2 border2 = i8 != 0 ? null : function25;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-712568069, $dirty, $dirty1, "androidx.compose.material.CommonDecorationBox (TextFieldImpl.kt:63)");
            }
            int i9 = (($dirty >> 3) & 14) | (($dirty >> 6) & 112);
            $composer3.startReplaceableGroup(511388516);
            ComposerKt.sourceInformation($composer3, "CC(remember)P(1,2):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer3.changed(value) | $composer3.changed(visualTransformation);
            Object it$iv$iv = $composer3.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = visualTransformation.filter(new AnnotatedString(value, null, null, 6, null));
                $composer3.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer3.endReplaceableGroup();
            final String transformedText = ((TransformedText) value$iv$iv).getText().getText();
            boolean isFocused = FocusInteractionKt.collectIsFocusedAsState(interactionSource, $composer3, ($dirty1 >> 3) & 14).getValue().booleanValue();
            if (isFocused) {
                inputPhase = InputPhase.Focused;
            } else {
                inputPhase = transformedText.length() == 0 ? InputPhase.UnfocusedEmpty : InputPhase.UnfocusedNotEmpty;
            }
            InputPhase inputState = inputPhase;
            final int $dirty2 = $dirty;
            final int $dirty12 = $dirty1;
            final boolean z2 = enabled3;
            final boolean z3 = isError4;
            Function3 labelColor = new Function3<InputPhase, Composer, Integer, Color>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$labelColor$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Color invoke(InputPhase inputPhase2, Composer composer, Integer num) {
                    return Color.m2939boximpl(m1251invokeXeAY9LY(inputPhase2, composer, num.intValue()));
                }

                /* renamed from: invoke-XeAY9LY, reason: not valid java name */
                public final long m1251invokeXeAY9LY(InputPhase it, Composer $composer4, int $changed2) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    $composer4.startReplaceableGroup(697243846);
                    ComposerKt.sourceInformation($composer4, "C92@3610L273:TextFieldImpl.kt#jmzs0o");
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(697243846, $changed2, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:91)");
                    }
                    long m2959unboximpl = TextFieldColors.this.labelColor(z2, it == InputPhase.UnfocusedEmpty ? false : z3, interactionSource, $composer4, (($dirty2 >> 27) & 14) | (($dirty12 << 3) & 896) | ($dirty12 & 7168)).getValue().m2959unboximpl();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    $composer4.endReplaceableGroup();
                    return m2959unboximpl;
                }
            };
            Typography typography = MaterialTheme.INSTANCE.getTypography($composer3, 6);
            TextStyle subtitle1 = typography.getSubtitle1();
            TextStyle caption = typography.getCaption();
            final boolean shouldOverrideTextStyleColor = (Color.m2950equalsimpl0(subtitle1.m4747getColor0d7_KjU(), Color.INSTANCE.m2985getUnspecified0d7_KjU()) && !Color.m2950equalsimpl0(caption.m4747getColor0d7_KjU(), Color.INSTANCE.m2985getUnspecified0d7_KjU())) || (!Color.m2950equalsimpl0(subtitle1.m4747getColor0d7_KjU(), Color.INSTANCE.m2985getUnspecified0d7_KjU()) && Color.m2950equalsimpl0(caption.m4747getColor0d7_KjU(), Color.INSTANCE.m2985getUnspecified0d7_KjU()));
            TextFieldTransitionScope textFieldTransitionScope = TextFieldTransitionScope.INSTANCE;
            $composer3.startReplaceableGroup(2129141006);
            ComposerKt.sourceInformation($composer3, "*110@4363L10,111@4455L22");
            long $this$CommonDecorationBox_u24lambda_u242 = MaterialTheme.INSTANCE.getTypography($composer3, 6).getCaption().m4747getColor0d7_KjU();
            if (shouldOverrideTextStyleColor) {
                long $this$takeOrElse_u2dDxMtmZc$iv = $this$CommonDecorationBox_u24lambda_u242;
                if (!($this$takeOrElse_u2dDxMtmZc$iv != Color.INSTANCE.m2985getUnspecified0d7_KjU())) {
                    $this$takeOrElse_u2dDxMtmZc$iv = labelColor.invoke(inputState, $composer3, 0).m2959unboximpl();
                }
                j = $this$takeOrElse_u2dDxMtmZc$iv;
            } else {
                j = $this$CommonDecorationBox_u24lambda_u242;
            }
            $composer3.endReplaceableGroup();
            $composer3.startReplaceableGroup(2129141197);
            ComposerKt.sourceInformation($composer3, "*113@4554L10,114@4648L22");
            long $this$CommonDecorationBox_u24lambda_u244 = MaterialTheme.INSTANCE.getTypography($composer3, 6).getSubtitle1().m4747getColor0d7_KjU();
            if (shouldOverrideTextStyleColor) {
                long $this$takeOrElse_u2dDxMtmZc$iv2 = $this$CommonDecorationBox_u24lambda_u244;
                if ($this$takeOrElse_u2dDxMtmZc$iv2 != Color.INSTANCE.m2985getUnspecified0d7_KjU()) {
                    z = false;
                } else {
                    z = false;
                    $this$takeOrElse_u2dDxMtmZc$iv2 = labelColor.invoke(inputState, $composer3, 0).m2959unboximpl();
                }
                j2 = $this$takeOrElse_u2dDxMtmZc$iv2;
            } else {
                z = false;
                j2 = $this$CommonDecorationBox_u24lambda_u244;
            }
            $composer3.endReplaceableGroup();
            boolean z4 = function2 != null ? true : z;
            final Function2 function26 = placeholder;
            final boolean z5 = isError4;
            final boolean z6 = enabled3;
            final Function2 function27 = leadingIcon2;
            final Function2 function28 = trailingIcon3;
            final boolean z7 = singleLine2;
            final Function2 function29 = border2;
            $composer2 = $composer3;
            textFieldTransitionScope.m1256TransitionDTcfvLk(inputState, j, j2, labelColor, z4, ComposableLambdaKt.composableLambda($composer2, 341865432, true, new Function6<Float, Color, Color, Float, Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3

                /* compiled from: TextFieldImpl.kt */
                @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
                /* loaded from: classes.dex */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[TextFieldType.values().length];
                        try {
                            iArr[TextFieldType.Filled.ordinal()] = 1;
                        } catch (NoSuchFieldError e) {
                        }
                        try {
                            iArr[TextFieldType.Outlined.ordinal()] = 2;
                        } catch (NoSuchFieldError e2) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(6);
                }

                @Override // kotlin.jvm.functions.Function6
                public /* bridge */ /* synthetic */ Unit invoke(Float f, Color color, Color color2, Float f2, Composer composer, Integer num) {
                    m1249invokeRIQooxk(f.floatValue(), color.m2959unboximpl(), color2.m2959unboximpl(), f2.floatValue(), composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:58:0x0158  */
                /* JADX WARN: Removed duplicated region for block: B:61:0x01d4  */
                /* JADX WARN: Removed duplicated region for block: B:64:0x01ed  */
                /* JADX WARN: Removed duplicated region for block: B:67:0x0270  */
                /* JADX WARN: Removed duplicated region for block: B:70:0x0290  */
                /* JADX WARN: Removed duplicated region for block: B:73:0x0400  */
                /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:76:0x029e  */
                /* JADX WARN: Removed duplicated region for block: B:88:0x03b1  */
                /* JADX WARN: Removed duplicated region for block: B:89:0x0282  */
                /* JADX WARN: Removed duplicated region for block: B:90:0x0230  */
                /* JADX WARN: Removed duplicated region for block: B:91:0x01e6  */
                /* JADX WARN: Removed duplicated region for block: B:92:0x0197  */
                /* renamed from: invoke-RIQooxk, reason: not valid java name */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final void m1249invokeRIQooxk(final float r34, final long r35, final long r37, final float r39, androidx.compose.runtime.Composer r40, int r41) {
                    /*
                        Method dump skipped, instructions count: 1036
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3.m1249invokeRIQooxk(float, long, long, float, androidx.compose.runtime.Composer, int):void");
                }
            }), $composer2, 1769472);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            border = border2;
            isError2 = isError4;
            isError3 = enabled3;
            enabled2 = singleLine2;
            trailingIcon = trailingIcon3;
            trailingIcon2 = leadingIcon2;
            leadingIcon = placeholder;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Function2 function210 = leadingIcon;
        final Function2 function211 = trailingIcon2;
        final Function2 function212 = trailingIcon;
        final boolean z8 = enabled2;
        final boolean z9 = isError3;
        final boolean z10 = isError2;
        final Function2 function213 = border;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$4
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
                TextFieldImplKt.CommonDecorationBox(TextFieldType.this, value, innerTextField, visualTransformation, function2, function210, function211, function212, z8, z9, z10, interactionSource, contentPadding, colors, function213, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), RecomposeScopeImplKt.updateChangedFlags($changed1), i);
            }
        });
    }

    /* renamed from: Decoration-euL9pac, reason: not valid java name */
    public static final void m1248DecorationeuL9pac(final long contentColor, TextStyle typography, Float contentAlpha, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        TextStyle textStyle;
        Float f;
        TextStyle typography2;
        Float contentAlpha2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-399493340);
        ComposerKt.sourceInformation($composer2, "C(Decoration)P(2:c#ui.graphics.Color,3,1):TextFieldImpl.kt#jmzs0o");
        int $dirty = $changed;
        if ((i & 1) != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(contentColor) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            textStyle = typography;
        } else if (($changed & 112) == 0) {
            textStyle = typography;
            $dirty |= $composer2.changed(textStyle) ? 32 : 16;
        } else {
            textStyle = typography;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            f = contentAlpha;
        } else if (($changed & 896) == 0) {
            f = contentAlpha;
            $dirty |= $composer2.changed(f) ? 256 : 128;
        } else {
            f = contentAlpha;
        }
        if ((i & 8) != 0) {
            $dirty |= 3072;
        } else if (($changed & 7168) == 0) {
            $dirty |= $composer2.changedInstance(content) ? 2048 : 1024;
        }
        final int $dirty2 = $dirty;
        if (($dirty2 & 5851) == 1170 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            typography2 = textStyle;
            contentAlpha2 = f;
        } else {
            TextStyle typography3 = i2 != 0 ? null : textStyle;
            Float contentAlpha3 = i3 != 0 ? null : f;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-399493340, $dirty2, -1, "androidx.compose.material.Decoration (TextFieldImpl.kt:233)");
            }
            final Float f2 = contentAlpha3;
            Function2 colorAndEmphasis = ComposableLambdaKt.composableLambda($composer2, 494684590, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1
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
                    ComposerKt.sourceInformation($composer3, "C240@9912L476:TextFieldImpl.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(494684590, $changed2, -1, "androidx.compose.material.Decoration.<anonymous> (TextFieldImpl.kt:239)");
                        }
                        ProvidedValue[] providedValueArr = {ContentColorKt.getLocalContentColor().provides(Color.m2939boximpl(contentColor))};
                        final Float f3 = f2;
                        final Function2<Composer, Integer, Unit> function2 = content;
                        final int i4 = $dirty2;
                        final long j = contentColor;
                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, ComposableLambdaKt.composableLambda($composer3, -1132188434, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$colorAndEmphasis$1.1
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
                                ComposerKt.sourceInformation($composer4, "C:TextFieldImpl.kt#jmzs0o");
                                if (($changed3 & 11) != 2 || !$composer4.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1132188434, $changed3, -1, "androidx.compose.material.Decoration.<anonymous>.<anonymous> (TextFieldImpl.kt:240)");
                                    }
                                    if (f3 != null) {
                                        $composer4.startReplaceableGroup(-452621938);
                                        ComposerKt.sourceInformation($composer4, "242@10036L142");
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(f3)}, function2, $composer4, ((i4 >> 6) & 112) | 8);
                                        $composer4.endReplaceableGroup();
                                    } else {
                                        $composer4.startReplaceableGroup(-452621758);
                                        ComposerKt.sourceInformation($composer4, "247@10216L148");
                                        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m2951getAlphaimpl(j)))}, function2, $composer4, ((i4 >> 6) & 112) | 8);
                                        $composer4.endReplaceableGroup();
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer4.skipToGroupEnd();
                            }
                        }), $composer3, 56);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            });
            if (typography3 != null) {
                $composer2.startReplaceableGroup(-2009952671);
                ComposerKt.sourceInformation($composer2, "254@10423L46");
                TextKt.ProvideTextStyle(typography3, colorAndEmphasis, $composer2, (($dirty2 >> 3) & 14) | 48);
            } else {
                $composer2.startReplaceableGroup(-2009952619);
                ComposerKt.sourceInformation($composer2, "254@10475L18");
                colorAndEmphasis.invoke($composer2, 6);
            }
            $composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            typography2 = typography3;
            contentAlpha2 = contentAlpha3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final TextStyle textStyle2 = typography2;
        final Float f3 = contentAlpha2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldImplKt$Decoration$1
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
                TextFieldImplKt.m1248DecorationeuL9pac(contentColor, textStyle2, f3, content, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    public static final int widthOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getWidth();
        }
        return 0;
    }

    public static final int heightOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getHeight();
        }
        return 0;
    }

    public static final Object getLayoutId(IntrinsicMeasurable $this$layoutId) {
        Intrinsics.checkNotNullParameter($this$layoutId, "<this>");
        Object parentData = $this$layoutId.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final float getHorizontalIconPadding() {
        return HorizontalIconPadding;
    }

    public static final Modifier getIconDefaultSizeModifier() {
        return IconDefaultSizeModifier;
    }
}
