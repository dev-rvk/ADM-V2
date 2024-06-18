package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.PainterModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Icon.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\u000f\u001a;\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\nH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\u0012\u001a\u0014\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0019\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"DefaultIconSizeModifier", "Landroidx/compose/ui/Modifier;", "Icon", "", "bitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "contentDescription", "", "modifier", "tint", "Landroidx/compose/ui/graphics/Color;", "Icon-ww6aTOc", "(Landroidx/compose/ui/graphics/ImageBitmap;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;JLandroidx/compose/runtime/Composer;II)V", "defaultSizeFor", "isInfinite", "", "Landroidx/compose/ui/geometry/Size;", "isInfinite-uvyYCjk", "(J)Z", "material_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class IconKt {
    private static final Modifier DefaultIconSizeModifier = SizeKt.m531size3ABfNKs(Modifier.INSTANCE, Dp.m5218constructorimpl(24));

    /* renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m1117Iconww6aTOc(ImageVector imageVector, String contentDescription, Modifier modifier, long tint, Composer $composer, int $changed, int i) {
        long tint2;
        long m2947copywmQWz5c;
        Intrinsics.checkNotNullParameter(imageVector, "imageVector");
        $composer.startReplaceableGroup(-800853103);
        ComposerKt.sourceInformation($composer, "C(Icon)P(1!,3:c#ui.graphics.Color)65@3149L7,65@3188L7,68@3229L34,67@3205L163:Icon.kt#jmzs0o");
        Modifier modifier2 = (i & 4) != 0 ? Modifier.INSTANCE : modifier;
        if ((i & 8) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            long m2959unboximpl = ((Color) consume).m2959unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd($composer);
            m2947copywmQWz5c = Color.m2947copywmQWz5c(m2959unboximpl, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(m2959unboximpl) : ((Number) consume2).floatValue(), (r12 & 2) != 0 ? Color.m2955getRedimpl(m2959unboximpl) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(m2959unboximpl) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(m2959unboximpl) : 0.0f);
            tint2 = m2947copywmQWz5c;
        } else {
            tint2 = tint;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-800853103, $changed, -1, "androidx.compose.material.Icon (Icon.kt:61)");
        }
        m1116Iconww6aTOc(VectorPainterKt.rememberVectorPainter(imageVector, $composer, $changed & 14), contentDescription, modifier2, tint2, $composer, VectorPainter.$stable | ($changed & 112) | ($changed & 896) | ($changed & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }

    /* renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m1115Iconww6aTOc(ImageBitmap bitmap, String contentDescription, Modifier modifier, long tint, Composer $composer, int $changed, int i) {
        long tint2;
        long m2947copywmQWz5c;
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        $composer.startReplaceableGroup(-554892675);
        ComposerKt.sourceInformation($composer, "C(Icon)P(!,3:c#ui.graphics.Color)99@4800L7,99@4839L7,101@4870L42,102@4917L136:Icon.kt#jmzs0o");
        Modifier modifier2 = (i & 4) != 0 ? Modifier.INSTANCE : modifier;
        if ((i & 8) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer);
            long m2959unboximpl = ((Color) consume).m2959unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd($composer);
            m2947copywmQWz5c = Color.m2947copywmQWz5c(m2959unboximpl, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(m2959unboximpl) : ((Number) consume2).floatValue(), (r12 & 2) != 0 ? Color.m2955getRedimpl(m2959unboximpl) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(m2959unboximpl) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(m2959unboximpl) : 0.0f);
            tint2 = m2947copywmQWz5c;
        } else {
            tint2 = tint;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-554892675, $changed, -1, "androidx.compose.material.Icon (Icon.kt:95)");
        }
        $composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean invalid$iv$iv = $composer.changed(bitmap);
        Object value$iv$iv = $composer.rememberedValue();
        if (invalid$iv$iv || value$iv$iv == Composer.INSTANCE.getEmpty()) {
            value$iv$iv = new BitmapPainter(bitmap, 0L, 0L, 6, null);
            $composer.updateRememberedValue(value$iv$iv);
        }
        $composer.endReplaceableGroup();
        BitmapPainter painter = (BitmapPainter) value$iv$iv;
        m1116Iconww6aTOc(painter, contentDescription, modifier2, tint2, $composer, ($changed & 112) | 8 | ($changed & 896) | ($changed & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceableGroup();
    }

    /* renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m1116Iconww6aTOc(final Painter painter, final String contentDescription, Modifier modifier, long tint, Composer $composer, final int $changed, final int i) {
        final long tint2;
        int $dirty;
        Modifier.Companion companion;
        Modifier paint;
        Object value$iv$iv;
        long tint3;
        Intrinsics.checkNotNullParameter(painter, "painter");
        Composer $composer2 = $composer.startRestartGroup(-1142959010);
        ComposerKt.sourceInformation($composer2, "C(Icon)P(2!,3:c#ui.graphics.Color)133@6456L7,133@6495L7,145@6878L253:Icon.kt#jmzs0o");
        Modifier modifier2 = (i & 4) != 0 ? Modifier.INSTANCE : modifier;
        if ((i & 8) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            long m2959unboximpl = ((Color) consume).m2959unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2 = $composer2.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            tint3 = Color.m2947copywmQWz5c(m2959unboximpl, (r12 & 1) != 0 ? Color.m2951getAlphaimpl(m2959unboximpl) : ((Number) consume2).floatValue(), (r12 & 2) != 0 ? Color.m2955getRedimpl(m2959unboximpl) : 0.0f, (r12 & 4) != 0 ? Color.m2954getGreenimpl(m2959unboximpl) : 0.0f, (r12 & 8) != 0 ? Color.m2952getBlueimpl(m2959unboximpl) : 0.0f);
            int $dirty2 = $changed & (-7169);
            $dirty = $dirty2;
            tint2 = tint3;
        } else {
            tint2 = tint;
            $dirty = $changed;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1142959010, $dirty, -1, "androidx.compose.material.Icon (Icon.kt:129)");
        }
        ColorFilter colorFilter = Color.m2950equalsimpl0(tint2, Color.INSTANCE.m2985getUnspecified0d7_KjU()) ? null : ColorFilter.Companion.m2990tintxETnrds$default(ColorFilter.INSTANCE, tint2, 0, 2, null);
        $composer2.startReplaceableGroup(1547387026);
        ComposerKt.sourceInformation($composer2, "138@6734L103");
        if (contentDescription != null) {
            Modifier.Companion companion2 = Modifier.INSTANCE;
            int i2 = ($dirty >> 3) & 14;
            $composer2.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer2, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer2.changed(contentDescription);
            Object it$iv$iv = $composer2.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.IconKt$Icon$semantics$1$1
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
                        SemanticsPropertiesKt.setContentDescription(semantics, contentDescription);
                        SemanticsPropertiesKt.m4582setRolekuIjeqM(semantics, Role.INSTANCE.m4571getImageo7Vup1c());
                    }
                };
                $composer2.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer2.endReplaceableGroup();
            companion = SemanticsModifierKt.semantics$default(companion2, false, (Function1) value$iv$iv, 1, null);
        } else {
            companion = Modifier.INSTANCE;
        }
        $composer2.endReplaceableGroup();
        Modifier semantics = companion;
        paint = PainterModifierKt.paint(defaultSizeFor(GraphicsLayerModifierKt.toolingGraphicsLayer(modifier2), painter), painter, (r14 & 2) != 0, (r14 & 4) != 0 ? Alignment.INSTANCE.getCenter() : null, (r14 & 8) != 0 ? ContentScale.INSTANCE.getInside() : ContentScale.INSTANCE.getFit(), (r14 & 16) != 0 ? 1.0f : 0.0f, (r14 & 32) != 0 ? null : colorFilter);
        BoxKt.Box(paint.then(semantics), $composer2, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final Modifier modifier3 = modifier2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.IconKt$Icon$1
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

            public final void invoke(Composer composer, int i3) {
                IconKt.m1116Iconww6aTOc(Painter.this, contentDescription, modifier3, tint2, composer, RecomposeScopeImplKt.updateChangedFlags($changed | 1), i);
            }
        });
    }

    private static final Modifier defaultSizeFor(Modifier $this$defaultSizeFor, Painter painter) {
        Modifier.Companion companion;
        if (Size.m2775equalsimpl0(painter.getIntrinsicSize(), Size.INSTANCE.m2787getUnspecifiedNHjbRc()) || m1118isInfiniteuvyYCjk(painter.getIntrinsicSize())) {
            companion = DefaultIconSizeModifier;
        } else {
            companion = Modifier.INSTANCE;
        }
        return $this$defaultSizeFor.then(companion);
    }

    /* renamed from: isInfinite-uvyYCjk, reason: not valid java name */
    private static final boolean m1118isInfiniteuvyYCjk(long $this$isInfinite_u2duvyYCjk) {
        return Float.isInfinite(Size.m2779getWidthimpl($this$isInfinite_u2duvyYCjk)) && Float.isInfinite(Size.m2776getHeightimpl($this$isInfinite_u2duvyYCjk));
    }
}
