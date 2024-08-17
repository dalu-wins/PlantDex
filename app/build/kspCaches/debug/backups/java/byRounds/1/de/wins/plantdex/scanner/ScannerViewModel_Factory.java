package de.wins.plantdex.scanner;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import de.wins.plantdex.core.data.PlantRepository;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class ScannerViewModel_Factory implements Factory<ScannerViewModel> {
  private final Provider<PlantRepository> plantRepositoryProvider;

  public ScannerViewModel_Factory(Provider<PlantRepository> plantRepositoryProvider) {
    this.plantRepositoryProvider = plantRepositoryProvider;
  }

  @Override
  public ScannerViewModel get() {
    return newInstance(plantRepositoryProvider.get());
  }

  public static ScannerViewModel_Factory create(Provider<PlantRepository> plantRepositoryProvider) {
    return new ScannerViewModel_Factory(plantRepositoryProvider);
  }

  public static ScannerViewModel newInstance(PlantRepository plantRepository) {
    return new ScannerViewModel(plantRepository);
  }
}
