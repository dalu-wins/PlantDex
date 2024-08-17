package de.wins.plantdex.datasheet;

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
public final class DatasheetViewModel_Factory implements Factory<DatasheetViewModel> {
  private final Provider<PlantRepository> plantRepositoryProvider;

  public DatasheetViewModel_Factory(Provider<PlantRepository> plantRepositoryProvider) {
    this.plantRepositoryProvider = plantRepositoryProvider;
  }

  @Override
  public DatasheetViewModel get() {
    return newInstance(plantRepositoryProvider.get());
  }

  public static DatasheetViewModel_Factory create(
      Provider<PlantRepository> plantRepositoryProvider) {
    return new DatasheetViewModel_Factory(plantRepositoryProvider);
  }

  public static DatasheetViewModel newInstance(PlantRepository plantRepository) {
    return new DatasheetViewModel(plantRepository);
  }
}
