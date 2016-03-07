package hotforms.com.br.realmtest.custom;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import hotforms.com.br.realmtest.R;


public class CustomProgressbar {
    private static ProgressDialog dialog;

    public static void show(final Context context) {
        show(context, false);
    }

    public static void show(final Context context, final boolean cancelable) {
        show(context, R.string.carregando, cancelable);
    }

    public static void show(final Context context, final int messageId) {
        show(context, context.getString(messageId), false);
    }

    public static void show(final Context context, final int messageId, final boolean cancelable) {
        show(context, context.getString(messageId), cancelable);
    }

    public static void show(final Context context, final String message) {
        show(context, message, false);
    }

    public static void show(final Context context, final String message, final boolean cancelable) {
        try {
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
                dialog = null;
            }
        } catch (Exception ex) {
            Log.e(CustomProgressbar.class.getSimpleName(), ex.getMessage());
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            dialog = new ProgressDialog(context, R.style.DialogTheme);
        else
            dialog = new ProgressDialog(context);

        dialog.setMessage(message);
        dialog.setIndeterminate(true);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setCancelable(cancelable);
        dialog.show();
    }

    public static void showWithProgress(final Context context, final int messageId, final int maxProgress) {
        try {
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
                dialog = null;
            }
        } catch (Exception ex) {
            Log.e(CustomProgressbar.class.getSimpleName(), ex.getMessage());
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            dialog = new ProgressDialog(context, R.style.DialogTheme);
        else
            dialog = new ProgressDialog(context);

        dialog.setMessage(context.getString(messageId));
        dialog.setIndeterminate(false);
        dialog.setCancelable(false);
        dialog.setMax(maxProgress);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.show();
    }

    public static void increaseProgressBar() {
        if (dialog != null) {
            int currentProgress = dialog.getProgress();
            currentProgress++;
            dialog.setProgress(currentProgress);
        }
    }

    public static void hide() {
        if (dialog == null) return;
        dialog.dismiss();
        dialog = null;
        Log.v("CustomProgressbar", "hide");
    }

    public static void updateProgressMessage(String message) {
        if (dialog != null)
            dialog.setMessage(message);
    }
}