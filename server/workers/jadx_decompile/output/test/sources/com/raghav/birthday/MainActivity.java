package com.raghav.birthday;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.button.MaterialButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0082 J\u0011\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0082 J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/raghav/birthday/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "isBase64", "", "textView", "Landroid/widget/TextView;", "decodeBase64", "", "input", "encodeBase64", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "toggleBase64", "Companion", "app_debug"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes3.dex */
public final class MainActivity extends AppCompatActivity {
    private boolean isBase64;
    private TextView textView;
    public static final int $stable = 8;

    private final native String decodeBase64(String input);

    private final native String encodeBase64(String input);

    static {
        System.loadLibrary("birthday");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View findViewById = findViewById(R.id.imageView);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        ImageView imageView = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.textView);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.textView = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.button);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        MaterialButton button = (MaterialButton) findViewById3;
        imageView.setImageResource(R.drawable.birthday_cake);
        TextView textView = this.textView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            textView = null;
        }
        textView.setText("04/10/2003");
        button.setOnClickListener(new View.OnClickListener() { // from class: com.raghav.birthday.MainActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.onCreate$lambda$0(MainActivity.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(MainActivity this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.toggleBase64();
    }

    private final void toggleBase64() {
        TextView textView = null;
        if (this.isBase64) {
            TextView textView2 = this.textView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
                textView2 = null;
            }
            String decodedText = decodeBase64(textView2.getText().toString());
            TextView textView3 = this.textView;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
            } else {
                textView = textView3;
            }
            textView.setText(decodedText);
        } else {
            TextView textView4 = this.textView;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
                textView4 = null;
            }
            String encodedText = encodeBase64(textView4.getText().toString());
            TextView textView5 = this.textView;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
            } else {
                textView = textView5;
            }
            textView.setText(encodedText);
        }
        this.isBase64 = !this.isBase64;
    }
}
