package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Surface.kt */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u0092\u0001\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001ap\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u009a\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a \u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00060#2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00060\b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010$\u001a%\u0010%\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0002H\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a;\u0010)\u001a\u00020\n*\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0013\u001a\u00020\u0002H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"LocalAbsoluteTonalElevation", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/unit/Dp;", "getLocalAbsoluteTonalElevation", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Surface", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "shadowElevation", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "Surface-o_FOJdg", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Surface-T9BRK9s", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selected", "Surface-d85dljk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJFFLandroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "surfaceColorAtElevation", "elevation", "surfaceColorAtElevation-CLU3JFs", "(JFLandroidx/compose/runtime/Composer;I)J", "surface", "backgroundColor", "surface-8ww4TTg", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SurfaceKt {
    private static final ProvidableCompositionLocal<Dp> LocalAbsoluteTonalElevation = CompositionLocalKt.compositionLocalOf$default(null, new Function0<Dp>() { // from class: androidx.compose.material3.SurfaceKt$LocalAbsoluteTonalElevation$1
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Dp invoke() {
            return Dp.m5216boximpl(m1802invokeD9Ej5fM());
        }

        /* renamed from: invoke-D9Ej5fM, reason: not valid java name */
        public final float m1802invokeD9Ej5fM() {
            return Dp.m5218constructorimpl(0);
        }
    }, 1, null);

    /* renamed from: Surface-T9BRK9s, reason: not valid java name */
    public static final void m1794SurfaceT9BRK9s(Modifier modifier, Shape shape, long color, long contentColor, float tonalElevation, float shadowElevation, BorderStroke border, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, int i) {
        Shape shape2;
        long color2;
        long contentColor2;
        float tonalElevation2;
        float shadowElevation2;
        BorderStroke border2;
        Intrinsics.checkNotNullParameter(content, "content");
        $composer.startReplaceableGroup(-513881741);
        ComposerKt.sourceInformation($composer, "C(Surface)P(4,6,1:c#ui.graphics.Color,3:c#ui.graphics.Color,7:c#ui.unit.Dp,5:c#ui.unit.Dp)102@5102L11,103@5149L22,*109@5366L7,110@5395L784:Surface.kt#uh7d8r");
        Modifier modifier2 = (i & 1) != 0 ? Modifier.INSTANCE : modifier;
        if ((i & 2) == 0) {
            shape2 = shape;
        } else {
            shape2 = RectangleShapeKt.getRectangleShape();
        }
        if ((i & 4) == 0) {
            color2 = color;
        } else {
            color2 = MaterialTheme.INSTANCE.getColorScheme($composer, 6).m1378getSurface0d7_KjU();
        }
        if ((i & 8) == 0) {
            contentColor2 = contentColor;
        } else {
            contentColor2 = ColorSchemeKt.m1414contentColorForek8zF_U(color2, $composer, ($changed >> 6) & 14);
        }
        if ((i & 16) == 0) {
            tonalElevation2 = tonalElevation;
        } else {
            tonalElevation2 = Dp.m5218constructorimpl(0);
        }
        if ((i & 32) == 0) {
            shadowElevation2 = shadowElevation;
        } else {
            shadowElevation2 = Dp.m5218constructorimpl(0);
        }
        if ((i & 64) != 0) {
            border2 = null;
        } else {
            border2 = border;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-513881741, $changed, -1, "androidx.compose.material3.Surface (Surface.kt:99)");
        }
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd($composer);
        float arg0$iv = ((Dp) consume).m5232unboximpl();
        final float absoluteElevation = Dp.m5218constructorimpl(arg0$iv + tonalElevation2);
        final Modifier modifier3 = modifier2;
        final Shape shape3 = shape2;
        final long j = color2;
        final BorderStroke borderStroke = border2;
        final float f = shadowElevation2;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2939boximpl(contentColor2)), LocalAbsoluteTonalElevation.provides(Dp.m5216boximpl(absoluteElevation))}, ComposableLambdaKt.composableLambda($composer, -70914509, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$1
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

            public final void invoke(Composer $composer2, int $changed2) {
                long m1801surfaceColorAtElevationCLU3JFs;
                Modifier m1800surface8ww4TTg;
                ComposerKt.sourceInformation($composer2, "C118@5685L139,114@5549L624:Surface.kt#uh7d8r");
                if (($changed2 & 11) != 2 || !$composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-70914509, $changed2, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:113)");
                    }
                    Modifier modifier4 = Modifier.this;
                    Shape shape4 = shape3;
                    m1801surfaceColorAtElevationCLU3JFs = SurfaceKt.m1801surfaceColorAtElevationCLU3JFs(j, absoluteElevation, $composer2, ($changed >> 6) & 14);
                    m1800surface8ww4TTg = SurfaceKt.m1800surface8ww4TTg(modifier4, shape4, m1801surfaceColorAtElevationCLU3JFs, borderStroke, f);
                    Modifier modifier$iv = SuspendingPointerInputFilterKt.pointerInput(SemanticsModifierKt.semantics(m1800surface8ww4TTg, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$1.1
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
                    }), Unit.INSTANCE, new AnonymousClass2(null));
                    Function2<Composer, Integer, Unit> function2 = content;
                    int i2 = $changed;
                    $composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, true, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    int $changed$iv$iv = (384 << 3) & 112;
                    $composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume2 = $composer2.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Density density$iv$iv = (Density) consume2;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume3 = $composer2.consume(localLayoutDirection);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume3;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume4 = $composer2.consume(localViewConfiguration);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume4;
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
                    int i3 = ($changed$iv$iv$iv >> 9) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    int i4 = ((384 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1301758814, "C131@6154L9:Surface.kt#uh7d8r");
                    function2.invoke($composer2, Integer.valueOf((i2 >> 21) & 14));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endReplaceableGroup();
                    $composer2.endNode();
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer2.skipToGroupEnd();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: Surface.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
            @DebugMetadata(c = "androidx.compose.material3.SurfaceKt$Surface$1$2", f = "Surface.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.material3.SurfaceKt$Surface$1$2, reason: invalid class name */
            /* loaded from: classes.dex */
            public static final class AnonymousClass2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                int label;

                AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
        }), $composer, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }

    /* renamed from: Surface-o_FOJdg, reason: not valid java name */
    public static final void m1797Surfaceo_FOJdg(final Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, float tonalElevation, float shadowElevation, BorderStroke border, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int $changed1, int i) {
        MutableInteractionSource interactionSource2;
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        $composer.startReplaceableGroup(-789752804);
        ComposerKt.sourceInformation($composer, "C(Surface)P(7,6,4,9,1:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.unit.Dp,8:c#ui.unit.Dp!1,5)206@10475L11,207@10522L22,211@10693L39,*214@10830L7,215@10859L917:Surface.kt#uh7d8r");
        Modifier modifier2 = (i & 2) != 0 ? Modifier.INSTANCE : modifier;
        boolean enabled2 = (i & 4) != 0 ? true : enabled;
        Shape shape2 = (i & 8) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        long color2 = (i & 16) != 0 ? MaterialTheme.INSTANCE.getColorScheme($composer, 6).m1378getSurface0d7_KjU() : color;
        long contentColor2 = (i & 32) != 0 ? ColorSchemeKt.m1414contentColorForek8zF_U(color2, $composer, ($changed >> 12) & 14) : contentColor;
        float tonalElevation2 = (i & 64) != 0 ? Dp.m5218constructorimpl(0) : tonalElevation;
        float shadowElevation2 = (i & 128) != 0 ? Dp.m5218constructorimpl(0) : shadowElevation;
        BorderStroke border2 = (i & 256) != 0 ? null : border;
        if ((i & 512) != 0) {
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                $composer.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            interactionSource2 = (MutableInteractionSource) value$iv$iv;
        } else {
            interactionSource2 = interactionSource;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-789752804, $changed, $changed1, "androidx.compose.material3.Surface (Surface.kt:201)");
        }
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd($composer);
        float arg0$iv = ((Dp) consume).m5232unboximpl();
        final float absoluteElevation = Dp.m5218constructorimpl(arg0$iv + tonalElevation2);
        final Modifier modifier3 = modifier2;
        final Shape shape3 = shape2;
        final long j = color2;
        final BorderStroke borderStroke = border2;
        final float f = shadowElevation2;
        final MutableInteractionSource mutableInteractionSource = interactionSource2;
        final boolean z = enabled2;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2939boximpl(contentColor2)), LocalAbsoluteTonalElevation.provides(Dp.m5216boximpl(absoluteElevation))}, ComposableLambdaKt.composableLambda($composer, 1279702876, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$3
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

            public final void invoke(Composer $composer2, int $changed2) {
                long m1801surfaceColorAtElevationCLU3JFs;
                Modifier m1800surface8ww4TTg;
                Modifier modifier$iv;
                ComposerKt.sourceInformation($composer2, "C224@11200L139,233@11570L16,219@11013L757:Surface.kt#uh7d8r");
                if (($changed2 & 11) != 2 || !$composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1279702876, $changed2, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:218)");
                    }
                    Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                    Shape shape4 = shape3;
                    m1801surfaceColorAtElevationCLU3JFs = SurfaceKt.m1801surfaceColorAtElevationCLU3JFs(j, absoluteElevation, $composer2, ($changed >> 12) & 14);
                    m1800surface8ww4TTg = SurfaceKt.m1800surface8ww4TTg(minimumInteractiveComponentSize, shape4, m1801surfaceColorAtElevationCLU3JFs, borderStroke, f);
                    modifier$iv = ClickableKt.m193clickableO2vRcR0(m1800surface8ww4TTg, mutableInteractionSource, RippleKt.m1286rememberRipple9IZ8Weo(false, 0.0f, 0L, $composer2, 0, 7), (r14 & 4) != 0 ? true : z, (r14 & 8) != 0 ? null : null, (r14 & 16) != 0 ? null : null, onClick);
                    Function2<Composer, Integer, Unit> function2 = content;
                    int i2 = $changed1;
                    $composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, true, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    int $changed$iv$iv = (384 << 3) & 112;
                    $composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume2 = $composer2.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Density density$iv$iv = (Density) consume2;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume3 = $composer2.consume(localLayoutDirection);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume3;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume4 = $composer2.consume(localViewConfiguration);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume4;
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
                    int i3 = ($changed$iv$iv$iv >> 9) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    int i4 = ((384 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1301753217, "C239@11751L9:Surface.kt#uh7d8r");
                    function2.invoke($composer2, Integer.valueOf(i2 & 14));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endReplaceableGroup();
                    $composer2.endNode();
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer2.skipToGroupEnd();
            }
        }), $composer, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }

    /* renamed from: Surface-d85dljk, reason: not valid java name */
    public static final void m1795Surfaced85dljk(final boolean selected, final Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, float tonalElevation, float shadowElevation, BorderStroke border, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int $changed1, int i) {
        MutableInteractionSource interactionSource2;
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        $composer.startReplaceableGroup(540296512);
        ComposerKt.sourceInformation($composer, "C(Surface)P(8,7,6,4,10,1:c#ui.graphics.Color,3:c#ui.graphics.Color,11:c#ui.unit.Dp,9:c#ui.unit.Dp!1,5)315@16017L11,316@16064L22,320@16235L39,*323@16372L7,324@16401L959:Surface.kt#uh7d8r");
        Modifier modifier2 = (i & 4) != 0 ? Modifier.INSTANCE : modifier;
        boolean enabled2 = (i & 8) != 0 ? true : enabled;
        Shape shape2 = (i & 16) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        long color2 = (i & 32) != 0 ? MaterialTheme.INSTANCE.getColorScheme($composer, 6).m1378getSurface0d7_KjU() : color;
        long contentColor2 = (i & 64) != 0 ? ColorSchemeKt.m1414contentColorForek8zF_U(color2, $composer, ($changed >> 15) & 14) : contentColor;
        float tonalElevation2 = (i & 128) != 0 ? Dp.m5218constructorimpl(0) : tonalElevation;
        float shadowElevation2 = (i & 256) != 0 ? Dp.m5218constructorimpl(0) : shadowElevation;
        BorderStroke border2 = (i & 512) != 0 ? null : border;
        if ((i & 1024) != 0) {
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                $composer.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            interactionSource2 = (MutableInteractionSource) value$iv$iv;
        } else {
            interactionSource2 = interactionSource;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(540296512, $changed, $changed1, "androidx.compose.material3.Surface (Surface.kt:309)");
        }
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd($composer);
        float arg0$iv = ((Dp) consume).m5232unboximpl();
        final float absoluteElevation = Dp.m5218constructorimpl(arg0$iv + tonalElevation2);
        final Modifier modifier3 = modifier2;
        final Shape shape3 = shape2;
        final long j = color2;
        final BorderStroke borderStroke = border2;
        final float f = shadowElevation2;
        final MutableInteractionSource mutableInteractionSource = interactionSource2;
        final boolean z = enabled2;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2939boximpl(contentColor2)), LocalAbsoluteTonalElevation.provides(Dp.m5216boximpl(absoluteElevation))}, ComposableLambdaKt.composableLambda($composer, -1164547968, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$5
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

            public final void invoke(Composer $composer2, int $changed2) {
                long m1801surfaceColorAtElevationCLU3JFs;
                Modifier m1800surface8ww4TTg;
                ComposerKt.sourceInformation($composer2, "C333@16742L139,343@17154L16,328@16555L799:Surface.kt#uh7d8r");
                if (($changed2 & 11) != 2 || !$composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1164547968, $changed2, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:327)");
                    }
                    Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                    Shape shape4 = shape3;
                    m1801surfaceColorAtElevationCLU3JFs = SurfaceKt.m1801surfaceColorAtElevationCLU3JFs(j, absoluteElevation, $composer2, ($changed >> 15) & 14);
                    m1800surface8ww4TTg = SurfaceKt.m1800surface8ww4TTg(minimumInteractiveComponentSize, shape4, m1801surfaceColorAtElevationCLU3JFs, borderStroke, f);
                    Modifier modifier$iv = SelectableKt.m709selectableO2vRcR0$default(m1800surface8ww4TTg, selected, mutableInteractionSource, RippleKt.m1286rememberRipple9IZ8Weo(false, 0.0f, 0L, $composer2, 0, 7), z, null, onClick, 16, null);
                    Function2<Composer, Integer, Unit> function2 = content;
                    int i2 = $changed1;
                    $composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, true, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    int $changed$iv$iv = (384 << 3) & 112;
                    $composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume2 = $composer2.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Density density$iv$iv = (Density) consume2;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume3 = $composer2.consume(localLayoutDirection);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume3;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume4 = $composer2.consume(localViewConfiguration);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume4;
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
                    int i3 = ($changed$iv$iv$iv >> 9) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    int i4 = ((384 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1301747633, "C349@17335L9:Surface.kt#uh7d8r");
                    function2.invoke($composer2, Integer.valueOf((i2 >> 3) & 14));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endReplaceableGroup();
                    $composer2.endNode();
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer2.skipToGroupEnd();
            }
        }), $composer, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }

    /* renamed from: Surface-d85dljk, reason: not valid java name */
    public static final void m1796Surfaced85dljk(final boolean checked, final Function1<? super Boolean, Unit> onCheckedChange, Modifier modifier, boolean enabled, Shape shape, long color, long contentColor, float tonalElevation, float shadowElevation, BorderStroke border, MutableInteractionSource interactionSource, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int $changed1, int i) {
        MutableInteractionSource interactionSource2;
        Object value$iv$iv;
        Intrinsics.checkNotNullParameter(onCheckedChange, "onCheckedChange");
        Intrinsics.checkNotNullParameter(content, "content");
        $composer.startReplaceableGroup(-1877401889);
        ComposerKt.sourceInformation($composer, "C(Surface)P(1,8,7,5,10,2:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.unit.Dp,9:c#ui.unit.Dp!1,6)425@21669L11,426@21716L22,430@21887L39,*433@22024L7,434@22053L969:Surface.kt#uh7d8r");
        Modifier modifier2 = (i & 4) != 0 ? Modifier.INSTANCE : modifier;
        boolean enabled2 = (i & 8) != 0 ? true : enabled;
        Shape shape2 = (i & 16) != 0 ? RectangleShapeKt.getRectangleShape() : shape;
        long color2 = (i & 32) != 0 ? MaterialTheme.INSTANCE.getColorScheme($composer, 6).m1378getSurface0d7_KjU() : color;
        long contentColor2 = (i & 64) != 0 ? ColorSchemeKt.m1414contentColorForek8zF_U(color2, $composer, ($changed >> 15) & 14) : contentColor;
        float tonalElevation2 = (i & 128) != 0 ? Dp.m5218constructorimpl(0) : tonalElevation;
        float shadowElevation2 = (i & 256) != 0 ? Dp.m5218constructorimpl(0) : shadowElevation;
        BorderStroke border2 = (i & 512) != 0 ? null : border;
        if ((i & 1024) != 0) {
            $composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation($composer, "CC(remember):Composables.kt#9igjgp");
            Object it$iv$iv = $composer.rememberedValue();
            if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                $composer.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            interactionSource2 = (MutableInteractionSource) value$iv$iv;
        } else {
            interactionSource2 = interactionSource;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1877401889, $changed, $changed1, "androidx.compose.material3.Surface (Surface.kt:419)");
        }
        ProvidableCompositionLocal<Dp> providableCompositionLocal = LocalAbsoluteTonalElevation;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(providableCompositionLocal);
        ComposerKt.sourceInformationMarkerEnd($composer);
        float arg0$iv = ((Dp) consume).m5232unboximpl();
        final float absoluteElevation = Dp.m5218constructorimpl(arg0$iv + tonalElevation2);
        final Modifier modifier3 = modifier2;
        final Shape shape3 = shape2;
        final long j = color2;
        final BorderStroke borderStroke = border2;
        final float f = shadowElevation2;
        final MutableInteractionSource mutableInteractionSource = interactionSource2;
        final boolean z = enabled2;
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m2939boximpl(contentColor2)), LocalAbsoluteTonalElevation.provides(Dp.m5216boximpl(absoluteElevation))}, ComposableLambdaKt.composableLambda($composer, 712720927, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$7
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

            public final void invoke(Composer $composer2, int $changed2) {
                long m1801surfaceColorAtElevationCLU3JFs;
                Modifier m1800surface8ww4TTg;
                ComposerKt.sourceInformation($composer2, "C443@22394L139,453@22802L16,438@22207L809:Surface.kt#uh7d8r");
                if (($changed2 & 11) != 2 || !$composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(712720927, $changed2, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:437)");
                    }
                    Modifier minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize(Modifier.this);
                    Shape shape4 = shape3;
                    m1801surfaceColorAtElevationCLU3JFs = SurfaceKt.m1801surfaceColorAtElevationCLU3JFs(j, absoluteElevation, $composer2, ($changed >> 15) & 14);
                    m1800surface8ww4TTg = SurfaceKt.m1800surface8ww4TTg(minimumInteractiveComponentSize, shape4, m1801surfaceColorAtElevationCLU3JFs, borderStroke, f);
                    Modifier modifier$iv = ToggleableKt.m713toggleableO2vRcR0$default(m1800surface8ww4TTg, checked, mutableInteractionSource, RippleKt.m1286rememberRipple9IZ8Weo(false, 0.0f, 0L, $composer2, 0, 7), z, null, onCheckedChange, 16, null);
                    Function2<Composer, Integer, Unit> function2 = content;
                    int i2 = $changed1;
                    $composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation($composer2, "CC(Box)P(2,1,3)70@3267L67,71@3339L130:Box.kt#2w3rfo");
                    Alignment contentAlignment$iv = Alignment.INSTANCE.getTopStart();
                    MeasurePolicy measurePolicy$iv = BoxKt.rememberBoxMeasurePolicy(contentAlignment$iv, true, $composer2, ((384 >> 3) & 14) | ((384 >> 3) & 112));
                    int $changed$iv$iv = (384 << 3) & 112;
                    $composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation($composer2, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume2 = $composer2.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Density density$iv$iv = (Density) consume2;
                    ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume3 = $composer2.consume(localLayoutDirection);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    LayoutDirection layoutDirection$iv$iv = (LayoutDirection) consume3;
                    ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume4 = $composer2.consume(localViewConfiguration);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ViewConfiguration viewConfiguration$iv$iv = (ViewConfiguration) consume4;
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
                    int i3 = ($changed$iv$iv$iv >> 9) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1253629305, "C72@3384L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    int i4 = ((384 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1301741971, "C459@22997L9:Surface.kt#uh7d8r");
                    function2.invoke($composer2, Integer.valueOf((i2 >> 3) & 14));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endReplaceableGroup();
                    $composer2.endNode();
                    $composer2.endReplaceableGroup();
                    $composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer2.skipToGroupEnd();
            }
        }), $composer, 56);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: surface-8ww4TTg, reason: not valid java name */
    public static final Modifier m1800surface8ww4TTg(Modifier $this$surface_u2d8ww4TTg, Shape shape, long backgroundColor, BorderStroke border, float shadowElevation) {
        Modifier m2621shadows4CzXII;
        m2621shadows4CzXII = ShadowKt.m2621shadows4CzXII($this$surface_u2d8ww4TTg, shadowElevation, (r15 & 2) != 0 ? RectangleShapeKt.getRectangleShape() : shape, (r15 & 4) != 0 ? Dp.m5217compareTo0680j_4(r8, Dp.m5218constructorimpl((float) 0)) > 0 : false, (r15 & 8) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (r15 & 16) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L);
        Modifier.Companion companion = Modifier.INSTANCE;
        if (border != null) {
            companion = BorderKt.border(companion, border, shape);
        }
        return ClipKt.clip(BackgroundKt.m162backgroundbw27NRU(m2621shadows4CzXII.then(companion), backgroundColor, shape), shape);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: surfaceColorAtElevation-CLU3JFs, reason: not valid java name */
    public static final long m1801surfaceColorAtElevationCLU3JFs(long color, float elevation, Composer $composer, int $changed) {
        long j;
        $composer.startReplaceableGroup(-2079918090);
        ComposerKt.sourceInformation($composer, "C(surfaceColorAtElevation)P(0:c#ui.graphics.Color,1:c#ui.unit.Dp)476@23481L11,477@23526L11:Surface.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2079918090, $changed, -1, "androidx.compose.material3.surfaceColorAtElevation (Surface.kt:475)");
        }
        if (Color.m2950equalsimpl0(color, MaterialTheme.INSTANCE.getColorScheme($composer, 6).m1378getSurface0d7_KjU())) {
            j = ColorSchemeKt.m1419surfaceColorAtElevation3ABfNKs(MaterialTheme.INSTANCE.getColorScheme($composer, 6), elevation);
        } else {
            j = color;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return j;
    }

    public static final ProvidableCompositionLocal<Dp> getLocalAbsoluteTonalElevation() {
        return LocalAbsoluteTonalElevation;
    }
}
