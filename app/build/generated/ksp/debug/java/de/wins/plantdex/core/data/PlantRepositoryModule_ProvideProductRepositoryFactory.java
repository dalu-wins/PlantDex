package de.wins.plantdex.core.data;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class PlantRepositoryModule_ProvideProductRepositoryFactory implements Factory<PlantRepository> {
  @Override
  public PlantRepository get() {
    return provideProductRepository();
  }

  public static PlantRepositoryModule_ProvideProductRepositoryFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static PlantRepository provideProductRepository() {
    return Preconditions.checkNotNullFromProvides(PlantRepositoryModule.INSTANCE.provideProductRepository());
  }

  private static final class InstanceHolder {
    private static final PlantRepositoryModule_ProvideProductRepositoryFactory INSTANCE = new PlantRepositoryModule_ProvideProductRepositoryFactory();
  }
}
