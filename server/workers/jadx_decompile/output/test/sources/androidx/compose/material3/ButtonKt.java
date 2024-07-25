package androidx.compose.material3;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: Button.kt */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u008d\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008d\u0001\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008d\u0001\u0010\u001b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008d\u0001\u0010\u001c\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008d\u0001\u0010\u001d\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001e"}, d2 = {"Button", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/ButtonColors;", "elevation", "Landroidx/compose/material3/ButtonElevation;", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ButtonColors;Landroidx/compose/material3/ButtonElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ElevatedButton", "FilledTonalButton", "OutlinedButton", "TextButton", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ButtonKt {
    /* JADX WARN: Removed duplicated region for block: B:100:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Button(final kotlin.jvm.functions.Function0<kotlin.Unit> r33, androidx.compose.ui.Modifier r34, boolean r35, androidx.compose.ui.graphics.Shape r36, androidx.compose.material3.ButtonColors r37, androidx.compose.material3.ButtonElevation r38, androidx.compose.foundation.BorderStroke r39, androidx.compose.foundation.layout.PaddingValues r40, androidx.compose.foundation.interaction.MutableInteractionSource r41, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, androidx.compose.runtime.Composer r43, final int r44, final int r45) {
        /*
            Method dump skipped, instructions count: 993
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ButtonKt.Button(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ButtonColors, androidx.compose.material3.ButtonElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0244  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ElevatedButton(final kotlin.jvm.functions.Function0<kotlin.Unit> r37, androidx.compose.ui.Modifier r38, boolean r39, androidx.compose.ui.graphics.Shape r40, androidx.compose.material3.ButtonColors r41, androidx.compose.material3.ButtonElevation r42, androidx.compose.foundation.BorderStroke r43, androidx.compose.foundation.layout.PaddingValues r44, androidx.compose.foundation.interaction.MutableInteractionSource r45, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, androidx.compose.runtime.Composer r47, final int r48, final int r49) {
        /*
            Method dump skipped, instructions count: 810
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ButtonKt.ElevatedButton(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ButtonColors, androidx.compose.material3.ButtonElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0244  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void FilledTonalButton(final kotlin.jvm.functions.Function0<kotlin.Unit> r37, androidx.compose.ui.Modifier r38, boolean r39, androidx.compose.ui.graphics.Shape r40, androidx.compose.material3.ButtonColors r41, androidx.compose.material3.ButtonElevation r42, androidx.compose.foundation.BorderStroke r43, androidx.compose.foundation.layout.PaddingValues r44, androidx.compose.foundation.interaction.MutableInteractionSource r45, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, androidx.compose.runtime.Composer r47, final int r48, final int r49) {
        /*
            Method dump skipped, instructions count: 810
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ButtonKt.FilledTonalButton(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ButtonColors, androidx.compose.material3.ButtonElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0222  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OutlinedButton(final kotlin.jvm.functions.Function0<kotlin.Unit> r32, androidx.compose.ui.Modifier r33, boolean r34, androidx.compose.ui.graphics.Shape r35, androidx.compose.material3.ButtonColors r36, androidx.compose.material3.ButtonElevation r37, androidx.compose.foundation.BorderStroke r38, androidx.compose.foundation.layout.PaddingValues r39, androidx.compose.foundation.interaction.MutableInteractionSource r40, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instructions count: 802
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ButtonKt.OutlinedButton(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ButtonColors, androidx.compose.material3.ButtonElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void TextButton(final kotlin.jvm.functions.Function0<kotlin.Unit> r33, androidx.compose.ui.Modifier r34, boolean r35, androidx.compose.ui.graphics.Shape r36, androidx.compose.material3.ButtonColors r37, androidx.compose.material3.ButtonElevation r38, androidx.compose.foundation.BorderStroke r39, androidx.compose.foundation.layout.PaddingValues r40, androidx.compose.foundation.interaction.MutableInteractionSource r41, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, androidx.compose.runtime.Composer r43, final int r44, final int r45) {
        /*
            Method dump skipped, instructions count: 788
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ButtonKt.TextButton(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, androidx.compose.material3.ButtonColors, androidx.compose.material3.ButtonElevation, androidx.compose.foundation.BorderStroke, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
