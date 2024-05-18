package com.nazran.retrofit.presentation.presenters;


import com.nazran.retrofit.domain.executor.Executor;
import com.nazran.retrofit.domain.executor.MainThread;

public abstract class AbstractPresenter {
    protected Executor mExecutor;
    protected MainThread mMainThread;

    public AbstractPresenter(Executor executor, MainThread mainThread) {
        mExecutor = executor;
        mMainThread = mainThread;
    }
}
